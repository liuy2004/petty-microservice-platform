package com.github.pettyfer.basic.auth.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Petty
 * @date 2018年2月28日
 * 获取用户信息
 */
@Log4j
@RestController
@RequestMapping(value = "resource")
public class ResourceController {

    /**
     * 通过access_token获取用户信息
     *
     * @param authentication
     * @return
     */
    @GetMapping("user")
    public Authentication getUser(Authentication authentication) {
        return authentication;
    }
}
