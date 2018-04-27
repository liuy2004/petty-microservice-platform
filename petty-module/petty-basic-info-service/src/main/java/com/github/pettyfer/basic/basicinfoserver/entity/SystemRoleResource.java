package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色资源关联
 * </p>
 *
 * @author Pettyfer
 * @since 2018-04-27
 */
@TableName("system_role_resource")
public class SystemRoleResource extends Model<SystemRoleResource> {

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
     * 资源编号
     */
    @TableField("RESOURCE_ID")
    private String resourceId;


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

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "SystemRoleResource{" +
        ", uuid=" + uuid +
        ", roleId=" + roleId +
        ", resourceId=" + resourceId +
        "}";
    }
}
