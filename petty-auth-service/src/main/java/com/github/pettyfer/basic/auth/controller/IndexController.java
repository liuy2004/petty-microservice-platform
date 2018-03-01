package com.github.pettyfer.basic.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/oauth")
public class IndexController {

    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "用户名或密码错误");
        }
        return "/index";
    }

    @PostMapping("/index")
    public String index(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "用户名或密码错误");
        }
        System.out.println("认证成功");
        return "/index";
    }
}
