package com.github.pettyfer.basic.auth.feign;

import com.github.pettyfer.basic.auth.feign.fallback.UserServiceFallbackImpl;
import com.github.pettyfer.basic.common.vo.UserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Petty
 */
@FeignClient(name = "petty-basic-info-server", fallback = UserServiceFallbackImpl.class)
public interface UserService {
    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return UserVo
     */
    @GetMapping("/user/findUserByUsername/{username}")
    UserVo findUserByUsername(@PathVariable("username") String username);
}
