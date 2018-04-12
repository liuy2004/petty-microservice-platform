package com.github.pettyfer.basic.oauth.feign;

import com.github.pettyfer.basic.oauth.feign.fallback.UserServiceFallbackImpl;
import com.github.pettyfer.basic.common.model.auth.User;
import com.github.pettyfer.basic.common.model.basic.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Petty
 * 远程调用基础信息服务-->用户接口
 */
@FeignClient(name = "petty-basic-info-service", fallback = UserServiceFallbackImpl.class)
public interface UserService {
    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return User
     */
    @GetMapping("/user/findUserByUsername/{username}")
    User findUserByUsername(@PathVariable("username") String username);

    /**
     * 通过用户手机号码查询用户、角色信息
     *
     * @param mobile 手机号码
     * @return User
     */
    @GetMapping("/user/findUserByMobile/{mobile}")
    User findUserByMobile(@PathVariable("mobile") String mobile);

    /**
     * 通过用户名查询用户详细信息
     * @param username
     * @return 用户信息详情对象
     */
    @GetMapping("/user/findUserInfoByUsername/{username}")
    UserInfo findUserInfoByUsername(@PathVariable("username") String username);
}
