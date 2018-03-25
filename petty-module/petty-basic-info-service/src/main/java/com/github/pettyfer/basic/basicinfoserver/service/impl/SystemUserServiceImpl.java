package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pettyfer.basic.basicinfoserver.entity.SystemUser;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemUserMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemUserService;
import com.github.pettyfer.basic.common.entity.User;
import com.github.pettyfer.basic.common.model.UserInfo;
import org.springframework.beans.BeanUtils;
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

    private final SystemUserMapper systemUserMapper;

    @Autowired
    public SystemUserServiceImpl(SystemUserMapper systemUserMapper) {
        this.systemUserMapper = systemUserMapper;
    }

    @Override
    public User findUserByUsername(String username) {
        return systemUserMapper.selectUserByUsername(username);
    }

    @Override
    public User findUserByMobile(String mobile) {
        return systemUserMapper.selectUserByMobile(mobile);
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        SystemUser systemUserQuery = new SystemUser();
        systemUserQuery.setUserName(username);
        systemUserQuery.setDelFlag(0);
        SystemUser systemUser = systemUserMapper.selectOne(systemUserQuery);
        BeanUtils.copyProperties(systemUser,userInfo);
        return userInfo;
    }
}
