package com.github.pettyfer.basic.basicinfoserver.controller;


import com.github.pettyfer.basic.basicinfoserver.service.ISystemUserService;
import com.github.pettyfer.basic.common.entity.User;
import com.github.pettyfer.basic.common.model.UserInfo;
import com.github.pettyfer.basic.common.response.BaseResponse;
import com.github.pettyfer.basic.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-27
 */
@RestController
@RequestMapping("/user")
public class SystemUserController extends BaseController {

    @Autowired
    private ISystemUserService systemUserService;

    @GetMapping("/info")
    public BaseResponse<User> user(User user) {
        return new BaseResponse<>(user);
    }

    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     * @return UseVo 对象
     */
    @GetMapping("/findUserByUsername/{username}")
    public User findUserByUsername(@PathVariable String username) {
        return systemUserService.findUserByUsername(username);
    }

    /**
     * 通过用户名查询用户详细信息
     * @param username
     * @return 用户信息详情对象
     */
    @GetMapping("/findUserInfoByUsername/{username}")
    public UserInfo findUserInfoByUsername(@PathVariable String username) {
        return systemUserService.findUserInfo(username);
    }
}

