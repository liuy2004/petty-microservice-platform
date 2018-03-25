package com.github.pettyfer.basic.oauth;

import com.github.pettyfer.basic.common.entity.User;
import com.github.pettyfer.basic.common.model.UserInfo;
import com.github.pettyfer.basic.oauth.feign.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    /**
     * 请求用户信息
     */
    @Test
    public void requestUserInfoByUsername() {
        UserInfo userInfo = userService.findUserInfoByUsername("admin");
        System.out.println(userInfo);
    }

    /**
     * 请求用户&角色信息
     */
    @Test
    public void requestUser() {
        User user = userService.findUserByUsername("admin");
        System.out.println(user);
    }

    /**
     * 请求用户&角色信息
     */
    @Test
    public void requestUserByMobile() {
        User user = userService.findUserByMobile("13094186549");
        System.out.println(user);
    }

}
