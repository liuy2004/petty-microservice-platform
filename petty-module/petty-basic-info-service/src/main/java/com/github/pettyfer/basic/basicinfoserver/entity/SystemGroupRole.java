package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户组角色关联信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-05-02
 */
@TableName("system_group_role")
public class SystemGroupRole extends Model<SystemGroupRole> {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId("UUID")
    private String uuid;
    /**
     * 用户组代码@SYSTEM_GROUP
     */
    @TableField("GROUP_CODE")
    private String groupCode;
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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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
        return "SystemGroupRole{" +
        ", uuid=" + uuid +
        ", groupCode=" + groupCode +
        ", roleCode=" + roleCode +
        "}";
    }
}
