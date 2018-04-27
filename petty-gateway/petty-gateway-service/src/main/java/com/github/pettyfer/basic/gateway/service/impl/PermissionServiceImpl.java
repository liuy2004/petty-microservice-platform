package com.github.pettyfer.basic.gateway.service.impl;

import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.github.pettyfer.basic.common.feign.ResourceInfoService;
import com.github.pettyfer.basic.common.model.basic.ResourceInfo;
import com.github.pettyfer.basic.gateway.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author Petty
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    private final ResourceInfoService resourceInfoService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    public PermissionServiceImpl(ResourceInfoService resourceInfoService) {
        this.resourceInfoService = resourceInfoService;
    }

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> simpleGrantedAuthority = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        boolean hasPermission = false;

        if (principal != null) {
            Set<ResourceInfo> resourceInfos = new HashSet<>();
            for (SimpleGrantedAuthority authority : simpleGrantedAuthority) {
                String role = authority.getAuthority().replace("{", "").replace("}", "").split("=")[1];
                Set<ResourceInfo> resourceInfoSet = resourceInfoService.findResourceByRole(role);
                if (resourceInfoSet != null) {
                    resourceInfos.addAll(resourceInfoSet);
                }
            }
            for (ResourceInfo resourceInfo : resourceInfos) {
                System.out.println(request.getRequestURI());
                System.out.println(request.getMethod());
                if (StringUtils.isNotEmpty(resourceInfo.getRequestUrl()) && antPathMatcher.match(resourceInfo.getRequestUrl(), request.getRequestURI()) && request.getMethod().equals(resourceInfo.getRequestMethod())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
