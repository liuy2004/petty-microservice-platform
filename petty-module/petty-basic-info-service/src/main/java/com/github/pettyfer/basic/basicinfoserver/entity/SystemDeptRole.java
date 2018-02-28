package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 部门角色关联信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@TableName("system_dept_role")
public class SystemDeptRole extends Model<SystemDeptRole> {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId("ID")
    private String id;
    /**
     * 部门代码
     */
    @TableField("DEPT_ID")
    private String deptId;
    /**
     * 角色代码
     */
    @TableField("ROLE_ID")
    private String roleId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SystemDeptRole{" +
        ", id=" + id +
        ", deptId=" + deptId +
        ", roleId=" + roleId +
        "}";
    }
}
