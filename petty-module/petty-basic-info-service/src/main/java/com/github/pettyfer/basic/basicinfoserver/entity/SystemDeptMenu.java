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
 * @since 2018-05-02
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
     * 部门编号@SYSTEM_DEPT
     */
    @TableField("DEPT_CODE")
    private String deptCode;
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

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
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
        return "SystemDeptMenu{" +
        ", uuid=" + uuid +
        ", deptCode=" + deptCode +
        ", menuCode=" + menuCode +
        "}";
    }
}
