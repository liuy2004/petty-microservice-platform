package com.github.pettyfer.basic.oauth.controller.resource;

import com.github.pettyfer.basic.common.annotation.UserContext;
import com.github.pettyfer.basic.common.utils.UserDetail;
import com.github.pettyfer.basic.common.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Petty
 * @date 2018年2月28日
 * 获取用户信息
 */
@Slf4j
@Api(value = "资源控制器", tags = {"资源接口"}, description = "获取用户资源")
@RestController
@RequestMapping(value = "resource")
public class ResourceController {

    /**
     * 通过access_token获取用户信息
     *
     * @return Authentication
     */
    @UserContext
    @ApiOperation(value = "获取用户信息", notes = "需要验证登陆令牌")
    @GetMapping("user")
    public UserDetail getUser() {
        return UserUtils.getUserDetail();
    }
}
