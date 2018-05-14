package com.github.pettyfer.basic.oauth.controller.admin;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.pettyfer.basic.common.model.basic.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员-用户管理
 * @author Petty
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping("user/list")
    public String index() {
        Page<UserInfo> userInfoPage = null;
        return "/admin/user/list";
    }

    @GetMapping("user/create")
    public String create() {
        return "/admin/user/create";
    }

    @GetMapping("user/group")
    public String group() {
        return "/admin/user/group";
    }
}
