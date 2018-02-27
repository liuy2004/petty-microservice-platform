package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 用户部门角色关联信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-27
 */
@TableName("system_user_dept_role")
public class SystemUserDeptRole extends Model<SystemUserDeptRole> {

    private static final long serialVersionUID = 1L;

    /**
     * UUID以后可能做迁移的唯一标准
     */
    @TableId("ID")
    private String id;
    /**
     * 用户代码@C_SYS_USER CODE
     */
    @TableField("USER_ID")
    private String userId;
    /**
     * 部门编码@C_SYS_DEPT CODE
     */
    @TableField("DEPT_ID")
    private String deptId;
    /**
     * 角色编码@C_SYS_ROLE
     */
    @TableField("ROLE_ID")
    private String roleId;
    /**
     * 是否默认选中@枚举 0-否；1-是
     */
    @TableField("IS_DEFAULT")
    private Integer isDefault;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SystemUserDeptRole{" +
                ", id=" + id +
                ", userId=" + userId +
                ", deptId=" + deptId +
                ", roleId=" + roleId +
                ", isDefault=" + isDefault +
                "}";
    }
}
