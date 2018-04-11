package com.github.pettyfer.basic.gateway.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Petty
 * 请求权限效验
 */
public interface PermissionService {
    /**
     * 判断是否有权限
     * @param request request
     * @param authentication authentication
     * @return boolean
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
