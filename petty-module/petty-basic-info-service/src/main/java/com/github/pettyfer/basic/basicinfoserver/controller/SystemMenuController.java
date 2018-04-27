package com.github.pettyfer.basic.basicinfoserver.controller;


import com.github.pettyfer.basic.basicinfoserver.service.impl.SystemMenuServiceImpl;
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
 * 菜单信息 前端控制器
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@Api(value = "菜单资源控制器", tags = {"菜单资源接口"}, description = "获取菜单资源")
@RestController
@RequestMapping("/menu")
public class SystemMenuController extends BaseController {

}

