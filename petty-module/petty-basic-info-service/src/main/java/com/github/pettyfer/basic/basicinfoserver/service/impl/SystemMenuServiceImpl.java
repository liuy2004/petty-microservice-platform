package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pettyfer.basic.basicinfoserver.entity.SystemMenu;
import com.github.pettyfer.basic.basicinfoserver.entity.SystemRole;
import com.github.pettyfer.basic.basicinfoserver.entity.SystemRoleMenu;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemMenuMapper;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemRoleMapper;
import com.github.pettyfer.basic.basicinfoserver.mapper.SystemRoleMenuMapper;
import com.github.pettyfer.basic.basicinfoserver.service.ISystemMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pettyfer.basic.common.model.basic.MenuInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单信息 服务实现类
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
@Service("systemMenuService")
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenu> implements ISystemMenuService {

    private final SystemRoleMapper systemRoleMapper;

    private final SystemRoleMenuMapper systemRoleMenuMapper;

    @Autowired
    public SystemMenuServiceImpl(SystemRoleMapper systemRoleMapper, SystemRoleMenuMapper systemRoleMenuMapper) {
        this.systemRoleMapper = systemRoleMapper;
        this.systemRoleMenuMapper = systemRoleMenuMapper;
    }

    /**
     * @param role 角色名称
     * @return Set<MenuInfo>
     */
    @Override
    @Cacheable(value = "basic:basic_menu", key = "'basic:basic_system_menu'.concat(':').concat(#role)")
    public Set<MenuInfo> searchMenuByRole(String role) {
        Set<MenuInfo> menuInfos = new HashSet<>();
        try {
            SystemRole systemRoleQuery = new SystemRole();
            systemRoleQuery.setRoleName(role);
            SystemRole systemRole = systemRoleMapper.selectOne(systemRoleQuery);
            SystemRoleMenu systemRoleMenuQuery = new SystemRoleMenu();
            systemRoleMenuQuery.setRoleId(systemRole.getRoleId());
            List<SystemRoleMenu> systemRoleMenus = systemRoleMenuMapper.selectList(new EntityWrapper<>(systemRoleMenuQuery));
            for (SystemRoleMenu systemRoleMenu : systemRoleMenus) {
                SystemMenu systemMenuQuery = new SystemMenu();
                systemMenuQuery.setMenuId(systemRoleMenu.getMenuId());
                SystemMenu systemMenu = baseMapper.selectOne(systemMenuQuery);
                MenuInfo menuInfo = new MenuInfo();
                BeanUtils.copyProperties(systemMenu, menuInfo);
                menuInfos.add(menuInfo);
            }
        } catch (NullPointerException e) {
            log.info("no find menu");
        }
        return menuInfos;
    }
}
