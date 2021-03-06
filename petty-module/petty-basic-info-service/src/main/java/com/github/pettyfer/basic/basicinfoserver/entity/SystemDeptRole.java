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
 * @since 2018-05-02
 */
@TableName("system_dept_role")
public class SystemDeptRole extends Model<SystemDeptRole> {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId("UUID")
    private String uuid;
    /**
     * 部门代码@SYSTEM_DEPT
     */
    @TableField("DEPT_CODE")
    private String deptCode;
    /**
     * 角色代码@SYSTEM_ROLE
     */
    @TableField("ROLE_CODE")
    private String roleCode;


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

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "SystemDeptRole{" +
        ", uuid=" + uuid +
        ", deptCode=" + deptCode +
        ", roleCode=" + roleCode +
        "}";
    }
}
