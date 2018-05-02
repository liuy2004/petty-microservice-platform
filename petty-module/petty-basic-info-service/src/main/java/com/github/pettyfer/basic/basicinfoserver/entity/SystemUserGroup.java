package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户用户组关联
 * </p>
 *
 * @author Pettyfer
 * @since 2018-05-02
 */
@TableName("system_user_group")
public class SystemUserGroup extends Model<SystemUserGroup> {

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
     * 用户组代码@SYSTEM_GROUP
     */
    @TableField("GROUP_CODE")
    private String groupCode;


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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "SystemUserGroup{" +
        ", uuid=" + uuid +
        ", userCode=" + userCode +
        ", groupCode=" + groupCode +
        "}";
    }
}
