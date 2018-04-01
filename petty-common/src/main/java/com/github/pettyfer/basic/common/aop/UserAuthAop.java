package com.github.pettyfer.basic.common.aop;

import com.github.pettyfer.basic.common.annotation.UserAuth;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author Petty
 */
@Aspect
@Order(9)
@Component
@Slf4j
public class UserAuthAop {

    /**
     * 切点
     */
    @Pointcut("@annotation(com.github.pettyfer.basic.common.annotation.UserAuth)")
    public void authPointCut() {
    }

    @Around("authPointCut()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println(request.getHeader("Authorization"));
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
            if (method.isAnnotationPresent(UserAuth.class)) {
                UserAuth userAuth = method.getAnnotation(UserAuth.class);
                System.out.println(userAuth.isUserDetails());
                object = joinPoint.proceed();
            } else {//没有使用@UserAuth注解直接放行
                joinPoint.proceed();
            }
        } else {
            joinPoint.proceed();
        }
        return object;
    }
}
