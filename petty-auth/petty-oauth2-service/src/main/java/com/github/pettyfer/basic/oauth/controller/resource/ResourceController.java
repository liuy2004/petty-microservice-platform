package com.github.pettyfer.basic.oauth.controller.resource;

import com.github.pettyfer.basic.common.annotation.UserAuth;
import com.github.pettyfer.basic.common.utils.UserDetail;
import com.github.pettyfer.basic.common.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Petty
 * @date 2018年2月28日
 * 获取用户信息
 */
@Slf4j
@Api(value = "ResourceController", description = "资源获取")
@RestController
@RequestMapping(value = "resource")
public class ResourceController {

    /**
     * 通过access_token获取用户信息
     *
     * @return Authentication
     */
    @UserAuth
    @ApiOperation(value = "获取用户信息", notes = "")
    @GetMapping("user")
    public UserDetail getUser() {
        return UserUtils.getUserDetail();
    }
}
