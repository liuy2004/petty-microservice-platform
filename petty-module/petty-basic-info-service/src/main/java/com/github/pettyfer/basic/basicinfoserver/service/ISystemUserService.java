package com.github.pettyfer.basic.basicinfoserver.service;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemUser;
import com.baomidou.mybatisplus.service.IService;
import com.github.pettyfer.basic.common.vo.UserVo;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
public interface ISystemUserService extends IService<SystemUser> {
    UserVo findUserByUsername(String username);
}
