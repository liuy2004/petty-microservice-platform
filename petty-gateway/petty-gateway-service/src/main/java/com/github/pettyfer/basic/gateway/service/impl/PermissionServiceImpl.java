package com.github.pettyfer.basic.gateway.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.github.pettyfer.basic.common.feign.MenuInfoService;
import com.github.pettyfer.basic.common.model.basic.MenuInfo;
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

    private final MenuInfoService menuInfoService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    public PermissionServiceImpl(MenuInfoService menuInfoService) {
        this.menuInfoService = menuInfoService;
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
            Set<MenuInfo> menuInfos = new HashSet<>();
            for (SimpleGrantedAuthority authority : simpleGrantedAuthority) {
                String role = authority.getAuthority().replace("{", "").replace("}", "").split("=")[1];
                Set<MenuInfo> menuInfoSet = menuInfoService.findMenuByRole(role);
                if (menuInfoSet != null) {
                    menuInfos.addAll(menuInfoSet);
                }
            }
            for (MenuInfo menuInfo : menuInfos) {
                System.out.println(request.getRequestURI());
                System.out.println(request.getMethod());
                if (StringUtils.isNotEmpty(menuInfo.getHref()) && antPathMatcher.match(menuInfo.getHref(), request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
