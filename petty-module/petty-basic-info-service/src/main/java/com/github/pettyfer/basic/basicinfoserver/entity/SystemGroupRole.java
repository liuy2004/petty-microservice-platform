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
 * @since 2018-02-28
 */
@TableName("system_group_role")
public class SystemGroupRole extends Model<SystemGroupRole> {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId("ID")
    private String id;
    /**
     * 用户组代码
     */
    @TableField("GROUP_ID")
    private String groupId;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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
        return "SystemGroupRole{" +
        ", id=" + id +
        ", groupId=" + groupId +
        ", roleId=" + roleId +
        "}";
    }
}
