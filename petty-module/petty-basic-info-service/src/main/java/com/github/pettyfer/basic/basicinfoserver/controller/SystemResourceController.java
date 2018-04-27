package com.github.pettyfer.basic.basicinfoserver.controller;


import com.github.pettyfer.basic.basicinfoserver.service.impl.SystemResourceServiceImpl;
import com.github.pettyfer.basic.common.model.basic.ResourceInfo;
import com.github.pettyfer.basic.common.web.BaseController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * <p>
 * 资源信息 前端控制器
 * </p>
 *
 * @author Pettyfer
 * @since 2018-04-27
 */
@Api(value = "用户资源控制器", tags = {"用户资源接口"}, description = "用户获取资源")
@RestController
@RequestMapping("/resource")
public class SystemResourceController extends BaseController {

    private final SystemResourceServiceImpl systemResourceService;

    @Autowired
    public SystemResourceController(SystemResourceServiceImpl systemResourceService) {
        this.systemResourceService = systemResourceService;
    }

    @GetMapping("findResourceByRole/{role}")
    public Set<ResourceInfo> findResourceByRole(@PathVariable("role") String role) {
        return systemResourceService.searchResourceByRole(role);
    }
}

