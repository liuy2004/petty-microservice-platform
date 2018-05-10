package com.github.pettyfer.basic.oauth.controller.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heyx
 */
@Controller
@RequestMapping("admin/user")
public class AdminUserController {

    @GetMapping("index")
    public String index() {
        return "/admin/user/index";
    }

    @GetMapping("create")
    public String create() {
        return "create";
    }

    @GetMapping("group")
    public String group() {
        return "group";
    }
}
