package com.github.pettyfer.basic.auth.controller.home;

import com.github.pettyfer.basic.auth.utils.SysUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Objects;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    /**
     * 根据用户角色跳转至相应页面
     * @param authentication
     * @return
     */
    @GetMapping(value = "dashboard")
    public String dashboard(Authentication authentication) {
        String home_url = "";
        if (SysUtil.hasRole(authentication.getAuthorities(), "ROLE_ADMIN")) {
            home_url = "/admin/index";
        } else if (SysUtil.hasRole(authentication.getAuthorities(), "ROLE_DEVELOPER")) {
            home_url = "/console/index";
        } else if (SysUtil.hasRole(authentication.getAuthorities(), "ROLE_USER")) {
            home_url = "/user/index";
        }
        return home_url;
    }


}
