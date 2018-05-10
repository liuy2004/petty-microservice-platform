package com.github.pettyfer.basic.oauth.controller.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heyx
 */
@Controller
@RequestMapping("admin/oauth2")
public class AdminOAuth2Controller{

    @GetMapping("resource")
    public String resource() {
        return "resource/index";
    }

    @GetMapping("scope")
    public String scope() {
        return "scope/index";
    }

    @GetMapping("authority")
    public String authority() {
        return "authority/index";
    }

    @GetMapping("client")
    public String client() {
        return "client/index";
    }

    @GetMapping("client/form")
    public String createClient() {
        return "client/form";
    }
}
