package com.github.pettyfer.basic.basicinfoserver.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pettyfer.basic.basicinfoserver.entity.SystemUser;
import com.github.pettyfer.basic.common.entity.User;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
public interface SystemUserMapper extends BaseMapper<SystemUser> {
    /**
     * 根据用户名称获取用户信息Entity
     *
     * @param username 用户名称
     * @return User
     */
    User selectUserByUsername(String username);

    /**
     * 根据用户手机号码称获取用户信息Entity
     *
     * @param mobile 手机号码
     * @return User
     */
    User selectUserByMobile(String mobile);
}
