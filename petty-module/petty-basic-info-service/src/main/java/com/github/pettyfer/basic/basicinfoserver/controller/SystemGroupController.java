package com.github.pettyfer.basic.basicinfoserver.controller;


import com.github.pettyfer.basic.common.model.basic.GroupInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 用户组信息 前端控制器
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@RestController
@RequestMapping("/group")
public class SystemGroupController {
    /**
     * 通过用户Id查询用户组信息
     * @param userId 用户唯一标识符
     * @return 用户组信息
     */
    @Cacheable(value = "basic:basic_group",key = "'basic:basic_system_group'.concat(':').concat(#userId)")
    @GetMapping("/findGroupInfoByUserId/{userId}")
    public List<GroupInfo> findGroupInfoByUserId(@PathVariable String userId) {
        return new LinkedList<>();
    }
}

