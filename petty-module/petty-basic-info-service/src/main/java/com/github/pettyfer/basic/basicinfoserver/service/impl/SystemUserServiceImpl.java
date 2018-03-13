package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemUser;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemUserMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pettyfer.basic.common.dto.UserDto;
import com.github.pettyfer.basic.common.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service("systemUserService")
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public UserDto findUserByUsername(String username) {
        return systemUserMapper.selectUserDtoByUsername(username);
    }

    @Override
    public UserInfo findUserInfo(String username) {
        return systemUserMapper.selectUserInfo(username);
    }
}
