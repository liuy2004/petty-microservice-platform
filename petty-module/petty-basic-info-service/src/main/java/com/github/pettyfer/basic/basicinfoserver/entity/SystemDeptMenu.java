package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 部门菜单关联
 * </p>
 *
 * @author Pettyfer
 * @since 2018-04-25
 */
@TableName("system_dept_menu")
public class SystemDeptMenu extends Model<SystemDeptMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId("UUID")
    private String uuid;
    /**
     * 部门编号
     */
    @TableField("DEPT_ID")
    private String deptId;
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
        return "SystemDeptMenu{" +
        ", uuid=" + uuid +
        ", deptId=" + deptId +
        ", menuId=" + menuId +
        "}";
    }
}
