package com.github.pettyfer.basic.oauth.controller.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heyx
 */
@Controller
@RequestMapping("admin")
public class AdminDashboardController {

    @GetMapping(value = {"/dashboard", "/", ""})
    public String index() {
        return "index";
    }
}
