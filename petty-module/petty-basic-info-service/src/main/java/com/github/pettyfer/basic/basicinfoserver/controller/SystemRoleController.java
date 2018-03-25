package com.github.pettyfer.basic.basicinfoserver.controller;


import com.github.pettyfer.basic.common.model.RoleInfo;
import com.github.pettyfer.basic.common.model.UserInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 角色信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@Controller
@RequestMapping("/role")
public class SystemRoleController {
    /**
     * 通过用户Id查询用户角色信息
     * @param userId 用户唯一标识符
     * @return 角色信息
     */
    @Cacheable(value = "basic:basic_role",key = "'basic:basic_system_role'.concat(':').concat(#userId)")
    @GetMapping("/findRoleInfoByUserId/{userId}")
    public RoleInfo findRoleInfoByUserId(@PathVariable String userId) {
        return new RoleInfo();
    }
}

