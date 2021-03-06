package com.github.pettyfer.basic.basicinfoserver.mapper;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pettyfer.basic.common.model.auth.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author Pettyfer
 * @since 2018-05-02
 */
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return User
     */
    User selectUserByUsername(@Param("username") String username);

    /**
     * 根据手机号码查询用户信息
     * @param mobile 手机号码
     * @return User
     */
    User selectUserByMobile(@Param("mobile") String mobile);
}
