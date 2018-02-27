package com.github.pettyfer.basic.basicinfoserver.mapper;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pettyfer.basic.common.vo.UserVo;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-27
 */
public interface SystemUserMapper extends BaseMapper<SystemUser> {
    /**
     * 通过用户名查询用户信息（含有角色信息）
     *
     * @param username 用户名
     * @return userVo
     */
    UserVo selectUserVoByUsername(String username);
}
