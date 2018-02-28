package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemUserDept;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemUserDeptMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemUserDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户部门关联信息 服务实现类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@Service("systemUserDeptService")
public class SystemUserDeptServiceImpl extends ServiceImpl<SystemUserDeptMapper, SystemUserDept> implements ISystemUserDeptService {

}
