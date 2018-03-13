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
    User findUserByUsername(String username);

    UserInfo findUserInfoByUsername(String username);
}
