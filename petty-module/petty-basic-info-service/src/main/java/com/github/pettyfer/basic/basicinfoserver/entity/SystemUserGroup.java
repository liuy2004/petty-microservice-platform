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
 * @since 2018-02-28
 */
@TableName("system_user_group")
public class SystemUserGroup extends Model<SystemUserGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId("ID")
    private String id;
    /**
     * 用户代码
     */
    @TableField("USER_ID")
    private String userId;
    /**
     * 用户组代码
     */
    @TableField("GROUP_ID")
    private String groupId;


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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SystemUserGroup{" +
        ", id=" + id +
        ", userId=" + userId +
        ", groupId=" + groupId +
        "}";
    }
}
