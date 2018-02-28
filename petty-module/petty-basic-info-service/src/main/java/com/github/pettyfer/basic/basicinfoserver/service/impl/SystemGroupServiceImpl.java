package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemGroup;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemGroupMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemGroupService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户组信息 服务实现类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@Service("systemGroupService")
public class SystemGroupServiceImpl extends ServiceImpl<SystemGroupMapper, SystemGroup> implements ISystemGroupService {

}
