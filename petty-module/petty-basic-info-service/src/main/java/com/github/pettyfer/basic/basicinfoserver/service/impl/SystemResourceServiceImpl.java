package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pettyfer.basic.basicinfoserver.entity.*;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemResourceMapper;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemRoleMapper;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemRoleResourceMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pettyfer.basic.common.model.basic.ResourceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 资源信息 服务实现类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-04-27
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
@Service
public class SystemResourceServiceImpl extends ServiceImpl<SystemResourceMapper, SystemResource> implements ISystemResourceService {

    private final SystemRoleResourceMapper systemRoleResourceMapper;

    private final SystemRoleMapper systemRoleMapper;

    @Autowired
    public SystemResourceServiceImpl(SystemRoleResourceMapper systemRoleResourceMapper, SystemRoleMapper systemRoleMapper) {
        this.systemRoleResourceMapper = systemRoleResourceMapper;
        this.systemRoleMapper = systemRoleMapper;
    }

    /**
     * @param role 角色名称
     * @return Set<ResourceInfo>
     */
    @Override
    @Cacheable(value = "basic:basic_resource", key = "'basic:basic_system_resource'.concat(':').concat(#role)")
    public Set<ResourceInfo> searchResourceByRole(String role) {
        Set<ResourceInfo> resourceInfos = new HashSet<>();
        try {
            SystemRole systemRoleQuery = new SystemRole();
            systemRoleQuery.setRoleName(role);
            SystemRole systemRole = systemRoleMapper.selectOne(systemRoleQuery);
            SystemRoleResource systemRoleResourceQuery = new SystemRoleResource();
            systemRoleResourceQuery.setRoleId(systemRole.getRoleId());
            List<SystemRoleResource> systemRoleResources = systemRoleResourceMapper.selectList(new EntityWrapper<>(systemRoleResourceQuery));
            for (SystemRoleResource systemRoleResource : systemRoleResources) {
                SystemResource systemResourceQuery = new SystemResource();
                systemResourceQuery.setResourceId(systemRoleResource.getResourceId());
                SystemResource systemMenu = baseMapper.selectOne(systemResourceQuery);
                ResourceInfo resourceInfo = new ResourceInfo();
                BeanUtils.copyProperties(systemMenu, resourceInfo);
                resourceInfos.add(resourceInfo);
            }
        } catch (NullPointerException e) {
            log.info("no find resource");
        }
        return resourceInfos;
    }
}
