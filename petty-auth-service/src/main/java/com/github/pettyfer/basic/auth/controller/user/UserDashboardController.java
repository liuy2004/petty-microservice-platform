package com.github.pettyfer.basic.auth.controller.user;


import com.alibaba.fastjson.JSONObject;
import com.github.pettyfer.basic.auth.utils.SysUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserDashboardController{

    @GetMapping(value = "dashboard")
    public String dashboard(Model model){
        System.out.println(JSONObject.toJSON(new SysUtil().getUser()));
        return "/user/index";
    }
}
