package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemDeptRole;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemDeptRoleMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemDeptRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门角色关联信息 服务实现类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@Service("systemDeptRoleService")
public class SystemDeptRoleServiceImpl extends ServiceImpl<SystemDeptRoleMapper, SystemDeptRole> implements ISystemDeptRoleService {

}
