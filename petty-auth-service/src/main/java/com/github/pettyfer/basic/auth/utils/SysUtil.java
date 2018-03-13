package com.github.pettyfer.basic.auth.utils;

import com.github.pettyfer.basic.auth.feign.UserService;
import com.github.pettyfer.basic.common.model.UserInfo;
import com.github.pettyfer.basic.common.utils.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;


@Slf4j
public class SysUtil {

    private static UserService userService = SpringContextHolder.getBean(UserService.class);

    public static UserInfo getUser() {
        try {
            SecurityContext ctx = SecurityContextHolder.getContext();
            Authentication auth = ctx.getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
            UserInfo userInfo = userService.findUserInfoByUsername(userDetails.getUsername());
            return userInfo;
        } catch (Exception e) {
            log.error("获取用户信息异常", e);
        }
        // 如果没有登录，则返回实例化空的User对象。
        return null;
    }
}
