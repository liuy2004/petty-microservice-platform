package com.github.pettyfer.basic.auth.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;


@Slf4j
public class SysUtil {
    public static UserDetailsImpl getUser() {
        try {
            SecurityContext ctx = SecurityContextHolder.getContext();
            Authentication auth = ctx.getAuthentication();
            UserDetailsImpl user = (UserDetailsImpl) auth.getPrincipal();
            return user;
        } catch (Exception e) {
            log.error("获取用户信息异常", e);
        }
        // 如果没有登录，则返回实例化空的User对象。
        return null;
    }
}
