package com.github.pettyfer.basic.basicinfoserver.service;

import com.github.pettyfer.basic.basicinfoserver.entity.SystemMenu;
import com.baomidou.mybatisplus.service.IService;
import com.github.pettyfer.basic.common.model.basic.MenuInfo;

import java.util.Set;

/**
 * <p>
 * 菜单信息 服务类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-03-08
 */
public interface ISystemMenuService extends IService<SystemMenu> {

    /**
     * 通过角色获取菜单信息
     *
     * @param role 角色名称
     * @return Set<MenuInfo>
     */
    Set<MenuInfo> searchMenuByRole(String role);
}
