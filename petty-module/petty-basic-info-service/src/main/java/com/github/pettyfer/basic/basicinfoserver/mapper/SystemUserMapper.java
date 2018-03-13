package com.github.pettyfer.basic.basicinfoserver.mapper;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pettyfer.basic.common.dto.UserDto;
import com.github.pettyfer.basic.common.vo.UserInfo;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
public interface SystemUserMapper extends BaseMapper<SystemUser> {
    UserDto selectUserDtoByUsername(String username);

    UserInfo selectUserInfo(String username);
}
