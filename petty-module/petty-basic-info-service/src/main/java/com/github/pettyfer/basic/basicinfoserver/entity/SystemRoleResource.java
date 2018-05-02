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
 * @since 2018-05-02
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
     * 角色编号@SYSTEM_ROLE
     */
    @TableField("ROLE_CODE")
    private String roleCode;
    /**
     * 资源编号@SYSTEM_RESOURCE
     */
    @TableField("RESOURCE_CODE")
    private String resourceCode;


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

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "SystemRoleResource{" +
        ", uuid=" + uuid +
        ", roleCode=" + roleCode +
        ", resourceCode=" + resourceCode +
        "}";
    }
}
