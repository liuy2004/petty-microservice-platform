package com.github.pettyfer.basic.auth.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserDashboardController{

    @GetMapping(value = "dashboard")
    public String dashboard(){
        return "/user/index";
    }
}
