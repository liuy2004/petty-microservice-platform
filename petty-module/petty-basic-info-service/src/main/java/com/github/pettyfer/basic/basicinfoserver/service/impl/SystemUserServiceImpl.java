package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pettyfer.basic.basicinfoserver.entity.SystemUser;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemUserMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemUserService;
import com.github.pettyfer.basic.common.model.auth.User;
import com.github.pettyfer.basic.common.model.basic.UserInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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

    @Override
    @Cacheable(value = "basic:basic_user", key = "'basic:basic_system_user'.concat(':').concat(#username)")
    public User findUserByUsername(String username) {
        return baseMapper.selectUserByUsername(username);
    }

    @Override
    @Cacheable(value = "basic:basic_user", key = "'basic:basic_system_user'.concat(':').concat(#mobile)")
    public User findUserByMobile(String mobile) {
        return baseMapper.selectUserByMobile(mobile);
    }

    @Override
    @Cacheable(value = "basic:basic_user_info", key = "'basic:basic_system_user_info'.concat(':').concat(#username)")
    public UserInfo findUserInfoByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        SystemUser systemUserQuery = new SystemUser();
        systemUserQuery.setUserName(username);
        systemUserQuery.setDelFlag(0);
        SystemUser systemUser = baseMapper.selectOne(systemUserQuery);
        BeanUtils.copyProperties(systemUser, userInfo);
        return userInfo;
    }

    /**
     * 查询分页数据
     *
     * @param userInfoPage 分页模型
     * @return list
     */
    @Override
    public List<UserInfo> pageUserInfo(Page<UserInfo> userInfoPage) {
        return null;
    }


}
