package com.github.pettyfer.basic.basicinfoserver.service;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemUser;
import com.baomidou.mybatisplus.service.IService;
import com.github.pettyfer.basic.common.entity.User;
import com.github.pettyfer.basic.common.model.UserInfo;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
public interface ISystemUserService extends IService<SystemUser> {

    /**
     * 根据用户名称号码称获取用户信息Entity
     *
     * @param username 用户名称
     * @return User
     */
    User findUserByUsername(String username);

    /**
     * 根据用户手机号码称获取用户信息Entity
     *
     * @param mobile 手机号码
     * @return User
     */
    User findUserByMobile(String mobile);

    /**
     * 根据用户名称获取用户基本信息Model
     *
     * @param username 用户名称
     * @return UserInfo
     */
    UserInfo findUserInfoByUsername(String username);
}
