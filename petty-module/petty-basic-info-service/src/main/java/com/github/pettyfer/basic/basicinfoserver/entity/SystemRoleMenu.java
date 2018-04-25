package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色菜单关联
 * </p>
 *
 * @author Pettyfer
 * @since 2018-04-25
 */
@TableName("system_role_menu")
public class SystemRoleMenu extends Model<SystemRoleMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId("UUID")
    private String uuid;
    /**
     * 角色编号
     */
    @TableField("ROLE_ID")
    private String roleId;
    /**
     * 菜单编号
     */
    @TableField("MENU_ID")
    private String menuId;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "SystemRoleMenu{" +
        ", uuid=" + uuid +
        ", roleId=" + roleId +
        ", menuId=" + menuId +
        "}";
    }
}
