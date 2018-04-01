package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 用户组信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@TableName("system_group")
public class SystemGroup extends Model<SystemGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("GROUP_ID")
    private String groupId;
    /**
     * 用户组名称
     */
    @TableField("GROUP_NAME")
    private String groupName;
    /**
     * 用户组父编号，顶级父编号为0
     */
    @TableField("PARENT_ID")
    private String parentId;
    /**
     * 用户组类型@1-访问安全控制用户组 2-基础资料子系统用户组
     */
    @TableField("GROUP_TYPE")
    private Integer groupType;
    /**
     * 排序
     */
    @TableField("SORT_NO")
    private Integer sortNo;
    /**
     * 是否启用 @枚举  0:否  1:是
     */
    @TableField("STATUS")
    private Integer status;
    /**
     * 创建人
     */
    @TableField("CREATOR")
    private String creator;
    /**
     * 创建时间
     */
    @TableField("CREATE_DATE")
    private String createDate;
    /**
     * 修改人
     */
    @TableField("MODIFIER")
    private String modifier;
    /**
     * 修改时间
     */
    @TableField("MODIFY_DATE")
    private String modifyDate;
    /**
     * 删除标记  @枚举  0:否；1:是
     */
    @TableField("DEL_FLAG")
    @TableLogic
    private Integer delFlag;


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.groupId;
    }

    @Override
    public String toString() {
        return "SystemGroup{" +
        ", groupId=" + groupId +
        ", groupName=" + groupName +
        ", parentId=" + parentId +
        ", groupType=" + groupType +
        ", sortNo=" + sortNo +
        ", status=" + status +
        ", creator=" + creator +
        ", createDate=" + createDate +
        ", modifier=" + modifier +
        ", modifyDate=" + modifyDate +
        ", delFlag=" + delFlag +
        "}";
    }
}
