package com.github.pettyfer.basic.gateway.service.impl;

import com.github.pettyfer.basic.gateway.service.PermissionService;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Petty
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        boolean hasPermission = false;
        System.out.println(request.getRequestURI());
        return hasPermission;
    }
}
