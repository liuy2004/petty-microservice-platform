package com.github.pettyfer.basic.basicinfoserver.controller;


import com.github.pettyfer.basic.basicinfoserver.service.ISystemUserService;
import com.github.pettyfer.basic.common.annotation.UserContext;
import com.github.pettyfer.basic.common.model.auth.User;
import com.github.pettyfer.basic.common.model.basic.UserInfo;
import com.github.pettyfer.basic.common.response.BaseResponse;
import com.github.pettyfer.basic.common.utils.UserUtils;
import com.github.pettyfer.basic.common.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
@Api(value="企业用户控制器", tags={"用户信息接口"}, description = "获取用户信息，或者对之进行修改")
@RestController
@RequestMapping("/user")
public class SystemUserController extends BaseController {

    private final ISystemUserService systemUserService;

    @Autowired
    public SystemUserController(ISystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @UserContext
    @ApiOperation(value = "测试接口", notes = "需要验证登陆令牌")
    @GetMapping("/info")
    public BaseResponse user() {
        System.out.println(UserUtils.getUserDetail());
        return new BaseResponse<>();
    }

    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     * @return UseVo 对象
     */
    @Cacheable(value = "basic:basic_user",key = "'basic:basic_system_user'.concat(':').concat(#username)")
    @GetMapping("/findUserByUsername/{username}")
    public User findUserByUsername(@PathVariable String username) {
        return systemUserService.findUserByUsername(username);
    }

    /**
     * 通过用户手机号码查询用户详细信息
     * @param mobile 手机号码
     * @return 用户信息详情对象
     */
    @Cacheable(value = "basic:basic_user",key = "'basic:basic_system_user'.concat(':').concat(#mobile)")
    @GetMapping("/findUserByMobile/{mobile}")
    public User findUserByMobile(@PathVariable String mobile) {
        return systemUserService.findUserByMobile(mobile);
    }

    /**
     * 通过用户名查询用户详细信息
     * @param username
     * @return 用户信息详情对象
     */
    @Cacheable(value = "basic:basic_user_info",key = "'basic:basic_system_user_info'.concat(':').concat(#username)")
    @GetMapping("/findUserInfoByUsername/{username}")
    public UserInfo findUserInfoByUsername(@PathVariable String username) {
        return systemUserService.findUserInfoByUsername(username);
    }
}

