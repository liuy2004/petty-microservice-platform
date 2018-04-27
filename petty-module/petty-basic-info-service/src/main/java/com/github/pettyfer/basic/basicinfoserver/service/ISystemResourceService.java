package com.github.pettyfer.basic.basicinfoserver.service;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemResource;
import com.baomidou.mybatisplus.service.IService;
import com.github.pettyfer.basic.common.model.basic.ResourceInfo;

import java.util.Set;

/**
 * <p>
 * 资源信息 服务类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-04-27
 */
public interface ISystemResourceService extends IService<SystemResource> {

    /**
     * 通过角色获取资源信息
     *
     * @param role 角色名称
     * @return Set<ResourceInfo>
     */
    Set<ResourceInfo> searchResourceByRole(String role);
}
