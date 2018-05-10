package com.github.pettyfer.basic.oauth.controller.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heyx
 */
@Controller
@RequestMapping("admin/dev")
public class AdminDeveloperInfoController {

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("pending")
    public String pending() {
        return "pending";
    }
}
