package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemGroupRole;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemGroupRoleMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemGroupRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户组角色关联信息 服务实现类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@Service("systemGroupRoleService")
public class SystemGroupRoleServiceImpl extends ServiceImpl<SystemGroupRoleMapper, SystemGroupRole> implements ISystemGroupRoleService {

}
