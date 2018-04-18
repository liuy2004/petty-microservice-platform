package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pettyfer.basic.basicinfoserver.entity.SystemRole;
import com.github.pettyfer.basic.basicinfoserver.entity.SystemUser;
import com.github.pettyfer.basic.basicinfoserver.entity.SystemUserRole;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemRoleMapper;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemUserMapper;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemUserRoleMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemUserService;
import com.github.pettyfer.basic.common.model.auth.Role;
import com.github.pettyfer.basic.common.model.auth.User;
import com.github.pettyfer.basic.common.model.basic.UserInfo;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
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

    private final SystemUserMapper systemUserMapper;

    private final SystemUserRoleMapper systemUserRoleMapper;

    private final SystemRoleMapper systemRoleMapper;

    @Autowired
    public SystemUserServiceImpl(SystemUserMapper systemUserMapper, SystemUserRoleMapper systemUserRoleMapper, SystemRoleMapper systemRoleMapper) {
        this.systemUserMapper = systemUserMapper;
        this.systemUserRoleMapper = systemUserRoleMapper;
        this.systemRoleMapper = systemRoleMapper;
    }

    @Override
    public User findUserByUsername(String username) {
        User user = new User();
        SystemUser systemUserQuery = new SystemUser();
        systemUserQuery.setUserName(username);
        SystemUser systemUser = systemUserMapper.selectOne(systemUserQuery);

        SystemUserRole systemUserRoleQuery = new SystemUserRole();
        systemUserQuery.setUserId(systemUser.getUserId());
        SystemUserRole systemUserRole = systemUserRoleMapper.selectOne(systemUserRoleQuery);

        SystemRole systemRoleQuery = new SystemRole();
        systemRoleQuery.setRoleId(systemUserRole.getRoleId());
        List<SystemRole> systemRoles = systemRoleMapper.selectList(new Wrapper<SystemRole>() {

            private static final long serialVersionUID = 2840132994715602216L;

            @Override
            public String getSqlSegment() {
                EntityWrapper<SystemRole> ew = new EntityWrapper<>();
                ew.setEntity(systemRoleQuery);
                return ew.getSqlSegment();
            }
        });

        HashSet<Role> roleHashSet = new HashSet<>();
        for (SystemRole s : systemRoles) {
            Role role = new Role();
            BeanUtils.copyProperties(s,role);
            roleHashSet.add(role);
        }
        List<Role> roles = new ArrayList<>(roleHashSet);

        BeanUtils.copyProperties(systemUser, user);
        user.setRoleList(roles);
        return user;
    }

    @Override
    public User findUserByMobile(String mobile) {
        User user = new User();
        SystemUser systemUserQuery = new SystemUser();
        systemUserQuery.setUserTel(mobile);
        SystemUser systemUser = systemUserMapper.selectOne(systemUserQuery);

        SystemUserRole systemUserRoleQuery = new SystemUserRole();
        systemUserQuery.setUserId(systemUser.getUserId());
        SystemUserRole systemUserRole = systemUserRoleMapper.selectOne(systemUserRoleQuery);

        SystemRole systemRoleQuery = new SystemRole();
        systemRoleQuery.setRoleId(systemUserRole.getRoleId());
        List<SystemRole> systemRoles = systemRoleMapper.selectList(new Wrapper<SystemRole>() {

            private static final long serialVersionUID = -6368731390232831383L;

            @Override
            public String getSqlSegment() {
                EntityWrapper<SystemRole> ew = new EntityWrapper<>();
                ew.setEntity(systemRoleQuery);
                return ew.getSqlSegment();
            }
        });

        HashSet<Role> roleHashSet = new HashSet<>();
        for (SystemRole s : systemRoles) {
            Role role = new Role();
            BeanUtils.copyProperties(s,role);
            roleHashSet.add(role);
        }
        List<Role> roles = new ArrayList<>(roleHashSet);
        BeanUtils.copyProperties(systemUser, user);
        user.setRoleList(roles);
        return user;
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        SystemUser systemUserQuery = new SystemUser();
        systemUserQuery.setUserName(username);
        systemUserQuery.setDelFlag(0);
        SystemUser systemUser = systemUserMapper.selectOne(systemUserQuery);
        BeanUtils.copyProperties(systemUser, userInfo);
        return userInfo;
    }
}
