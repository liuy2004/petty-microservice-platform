package com.github.pettyfer.basic.basicinfoserver.mapper;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemResource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pettyfer.basic.common.model.basic.ResourceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 * 资源信息 Mapper 接口
 * </p>
 *
 * @author Pettyfer
 * @since 2018-05-02
 */
public interface SystemResourceMapper extends BaseMapper<SystemResource> {
    /**
     * 根据角色查询资源信息
     * @param role 用户名
     * @return ResourceInfo
     */
    Set<ResourceInfo> selectResourceInfoByRole(@Param("role") String role);
}
