package com.github.pettyfer.basic.common.aop;

import com.github.pettyfer.basic.common.constant.SecurityConstant;
import com.github.pettyfer.basic.common.vo.UserVo;
import com.github.pettyfer.basic.common.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * 通过Aop对Controller返回数据进行包装
 * @author Petty
 * @date 2018年3月1日
 */
@Aspect
@Component
public class ControllerAop {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    @Autowired
    private CacheManager cacheManager;

    @Pointcut("execution(public com.github.pettyfer.basic.common.response.BaseResponse *(..))")
    public void pointCutResponse() {
    }

    /**
     * 处理切点
     * @param pjp
     * @return
     */
    @Around("pointCutResponse()")
    public Object methodRHandler(ProceedingJoinPoint pjp) {
        return methodHandler(pjp);
    }


    @Pointcut("execution(public com.baomidou.mybatisplus.plugins.Page *(..))")
    public void pointCutPage() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp 切点 所有返回对象Page
     * @return BaseResponse  结果包装
     */
    @Around("pointCutPage()")
    public Object methodPageHandler(ProceedingJoinPoint pjp) {
        return methodHandler(pjp);
    }

    private Object methodHandler(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String token = UserUtils.getToken(request);
        UserVo userVo = null;
        if (StringUtils.isNotEmpty(token)) {
            userVo = cacheManager.getCache(SecurityConstant.TOKEN_USER_DETAIL).get(token, UserVo.class);
        }
        String username;
        if (userVo == null) {
            username = UserUtils.getUserName(request);
            if (StringUtils.isNotEmpty(username)) {
                UserUtils.setUser(username);
            }
        } else {
            username = userVo.getUserName();
            UserUtils.setUser(username);
        }
        logger.info("Controller AOP get username:{}", username);

        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(pjp.getArgs()));

        Object result;

        try {
            result = pjp.proceed();
            logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            logger.error("异常信息：", e);
            throw new RuntimeException(e);
        } finally {
            if (StringUtils.isNotEmpty(username)) {
                UserUtils.clearAllUserInfo();
            }
        }
        return result;
    }
}
