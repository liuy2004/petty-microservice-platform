package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户角色关联信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-05-02
 */
@TableName("system_user_role")
public class SystemUserRole extends Model<SystemUserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId("UUID")
    private String uuid;
    /**
     * 用户代码@SYSTEM_USER
     */
    @TableField("USER_CODE")
    private String userCode;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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
        return "SystemUserRole{" +
        ", uuid=" + uuid +
        ", userCode=" + userCode +
        ", roleCode=" + roleCode +
        "}";
    }
}
