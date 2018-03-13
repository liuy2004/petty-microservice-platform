package com.github.pettyfer.basic.auth.feign.fallback;

import com.github.pettyfer.basic.auth.feign.UserService;
import com.github.pettyfer.basic.common.entity.User;
import com.github.pettyfer.basic.common.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @author Petty
 * Feign回调容错处理
 */
@Service("userService")
public class UserServiceFallbackImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User findUserByUsername(String username) {
        logger.error("调用{}异常:{}", "findUserByUsername", username);
        return null;
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        logger.error("调用{}异常:{}", "findUserInfoByUsername", username);
        return null;
    }
}
