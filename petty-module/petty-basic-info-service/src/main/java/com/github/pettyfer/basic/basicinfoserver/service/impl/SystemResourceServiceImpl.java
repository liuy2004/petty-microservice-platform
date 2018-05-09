package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pettyfer.basic.basicinfoserver.entity.SystemResource;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemResourceMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemResourceService;
import com.github.pettyfer.basic.common.model.basic.ResourceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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

    /**
     * @param role 角色名称
     * @return Set<ResourceInfo>
     */
    @Override
    @Cacheable(value = "basic:basic_resource", key = "'basic:basic_system_resource'.concat(':').concat(#role)")
    public Set<ResourceInfo> searchResourceByRole(String role) {
        return baseMapper.selectResourceInfoByRole(role);
    }
}
