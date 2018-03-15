package com.github.pettyfer.basic.oauth.controller.home;

import com.github.pettyfer.basic.oauth.utils.SysUtil;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    /**
     * 根据用户角色跳转至相应页面
     * @param authentication
     * @return
     */
    @GetMapping(value = "dashboard")
    public String dashboard(Model model, Authentication authentication) {
        String home_url = "";
        model.addAttribute("userInfo",SysUtil.getUser());
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
