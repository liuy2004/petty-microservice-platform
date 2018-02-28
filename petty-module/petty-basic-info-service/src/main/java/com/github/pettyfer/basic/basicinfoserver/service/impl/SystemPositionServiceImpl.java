package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemPosition;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemPositionMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemPositionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户岗位信息 服务实现类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@Service("systemPositionService")
public class SystemPositionServiceImpl extends ServiceImpl<SystemPositionMapper, SystemPosition> implements ISystemPositionService {

}
