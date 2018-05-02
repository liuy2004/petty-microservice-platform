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
 * @since 2018-05-02
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
     * 角色编号@SYSTEM_ROLE
     */
    @TableField("ROLE_CODE")
    private String roleCode;
    /**
     * 菜单编号@SYSTEM_MENU
     */
    @TableField("MENU_CODE")
    private String menuCode;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "SystemRoleMenu{" +
        ", uuid=" + uuid +
        ", roleCode=" + roleCode +
        ", menuCode=" + menuCode +
        "}";
    }
}
