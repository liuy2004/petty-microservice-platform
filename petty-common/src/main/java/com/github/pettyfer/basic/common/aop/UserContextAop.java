package com.github.pettyfer.basic.common.aop;

import com.github.pettyfer.basic.common.annotation.UserContext;
import com.github.pettyfer.basic.common.constant.SecurityConstant;
import com.github.pettyfer.basic.common.context.BaseContextHandler;
import com.github.pettyfer.basic.common.context.SessionContext;
import com.github.pettyfer.basic.common.exception.auth.TokenErrorException;
import com.github.pettyfer.basic.common.model.auth.Role;
import com.github.pettyfer.basic.common.model.auth.User;
import com.github.pettyfer.basic.common.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author Petty
 */
@Aspect
@Order(9)
@Component
@Slf4j
public class UserContextAop {

    private final CacheManager cacheManager;

    @Autowired
    public UserContextAop(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    /**
     * 切点
     */
    @Pointcut("@annotation(com.github.pettyfer.basic.common.annotation.UserContext)")
    public void authPointCut() {
    }

    @Around("authPointCut()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取当前运行类
        Object target = joinPoint.getTarget();
        //获取当前方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取当前切点标签
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只可在方法上使用");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        Class[] classes = methodSignature.getMethod().getParameterTypes();
        Method method = null;
        Object object = null;
        try {
            method = target.getClass().getMethod(methodName, classes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (method != null) {
            if (method.isAnnotationPresent(UserContext.class)) {
                Object obj = null;
                String token = TokenUtils.getToken(request);
                if (StringUtils.isBlank(token)) {
                    log.error("resolveArgument error token is empty");
                    throw new TokenErrorException("invalid token");
                }
                Optional<User> userOptional = Optional.ofNullable(cacheManager.getCache(SecurityConstant.TOKEN_USER_DETAIL).get(token, User.class));
                if (userOptional.isPresent()) {
                    log.info("return cache user entity,token :{}", token);
                    userOptional.get();
                }
                obj = userOptional.orElseGet(() -> generatorByToken(request, token));
                SessionContext.setUser((User) obj);
                object = joinPoint.proceed();
            } else {//没有使用@UserAuth注解直接放行
                joinPoint.proceed();
            }
        } else {
            joinPoint.proceed();
        }
        return object;
    }

    /**
     * 切点执行结束清楚ThreadLocal防止内存溢出
     */
    @After("authPointCut()")
    public void after() {
        BaseContextHandler.remove();
    }

    /**
     * 更绝Token解析用户信息并存入Redis
     *
     * @param request
     * @param token
     * @return
     */
    private User generatorByToken(HttpServletRequest request, String token) {
        String username = TokenUtils.getUserName(request);
        List<LinkedHashMap<String, String>> roles = TokenUtils.getRole(request);
        log.info("Auth-Token-User:{}-Roles:{}", username, roles);
        User user = new User();
        user.setUserName(username);
        List<Role> sysRoleList = new ArrayList<>();
        roles.stream().forEach(role -> {
            Role sysRole = new Role();
            sysRole.setRoleName(role.get("authority"));
            sysRoleList.add(sysRole);
        });
        user.setRoleList(sysRoleList);
        cacheManager.getCache(SecurityConstant.TOKEN_USER_DETAIL).put(token, user);
        return user;
    }
}
