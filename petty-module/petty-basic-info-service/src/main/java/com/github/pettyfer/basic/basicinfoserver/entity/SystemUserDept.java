package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户部门关联信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@TableName("system_user_dept")
public class SystemUserDept extends Model<SystemUserDept> {

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
     * 部门编码
     */
    @TableField("DEPT_ID")
    private String deptId;


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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SystemUserDept{" +
        ", id=" + id +
        ", userId=" + userId +
        ", deptId=" + deptId +
        "}";
    }
}
