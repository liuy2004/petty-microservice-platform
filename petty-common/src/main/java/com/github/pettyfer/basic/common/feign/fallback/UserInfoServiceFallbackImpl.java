package com.github.pettyfer.basic.common.feign.fallback;

import com.github.pettyfer.basic.common.feign.UserInfoService;
import com.github.pettyfer.basic.common.model.auth.User;
import com.github.pettyfer.basic.common.model.basic.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @author Petty
 * Feign回调容错处理
 */
@Service
public class UserInfoServiceFallbackImpl implements UserInfoService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User findUserByUsername(String username) {
        logger.error("调用{}异常:{}", "findUserByUsername", username);
        return null;
    }

    @Override
    public User findUserByMobile(String mobile) {
        logger.error("调用{}异常:{}", "findUserByMobile", mobile);
        return null;
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        logger.error("调用{}异常:{}", "findUserInfoByUsername", username);
        return null;
    }
}
