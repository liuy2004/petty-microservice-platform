package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemUserGroup;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemUserGroupMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemUserGroupService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户用户组关联 服务实现类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@Service("systemUserGroupService")
public class SystemUserGroupServiceImpl extends ServiceImpl<SystemUserGroupMapper, SystemUserGroup> implements ISystemUserGroupService {

}
