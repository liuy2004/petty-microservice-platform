package com.github.pettyfer.basic.oauth.controller.home;

import com.github.pettyfer.basic.common.constant.SecurityConstant;
import com.github.pettyfer.basic.oauth.utils.RoleUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Petty
 */
@Controller
@RequestMapping(value = "home")
public class HomeController {

    /**
     * 根据用户角色跳转至相应页面
     *
     * @param authentication
     * @return
     */
    @GetMapping(value = "dashboard")
    public String dashboard(Model model, Authentication authentication) {
        model.addAttribute("userInfo", RoleUtils.getUser());
        /*if (RoleUtils.hasRole(authentication.getAuthorities(), SecurityConstant.ADMIN_ROLE)) {
            homeUrl = "/admin/index";
        } else if (RoleUtils.hasRole(authentication.getAuthorities(), SecurityConstant.DEVELOPER_ROLE)) {
            homeUrl = "/console/index";
        } else if (RoleUtils.hasRole(authentication.getAuthorities(), SecurityConstant.BASE_ROLE)) {
            homeUrl = "/user/index";
        }*/
        return "/index";
    }


}
