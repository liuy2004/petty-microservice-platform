package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 部门信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@TableName("system_dept")
public class SystemDept extends Model<SystemDept> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("DEPT_ID")
    private String deptId;
    /**
     * 上级ID标识
     */
    @TableField("PARENT_ID")
    private String parentId;
    /**
     * 部门名称
     */
    @TableField("DEPT_NAME")
    private String deptName;
    /**
     * 部门简称
     */
    @TableField("DEPT_SHORT_NAME")
    private String deptShortName;
    /**
     * 部门类型
     */
    @TableField("DEPT_TYPE")
    private String deptType;
    /**
     * 部门组织架构层级编码
     */
    @TableField("DEPT_FRAM_ID")
    private String deptFramId;
    /**
     * 组织机构代码
     */
    @TableField("ORG_ID")
    private String orgId;
    /**
     * 部门描述
     */
    @TableField("DEPT_DESC")
    private String deptDesc;
    /**
     * 主负责人
     */
    @TableField("LEADER")
    private String leader;
    /**
     * 副负责人，多个用逗号隔开
     */
    @TableField("DEPUTY_LEADER")
    private String deputyLeader;
    /**
     * 联系电话
     */
    @TableField("TEL_PHONE")
    private String telPhone;
    /**
     * 联系地址
     */
    @TableField("ADDRESS")
    private String address;
    /**
     * 同层部门等级
     */
    @TableField("DEPT_GRADE")
    private Integer deptGrade;
    /**
     * 区域编号
     */
    @TableField("AREA_CODE")
    private String areaCode;
    /**
     * 排序
     */
    @TableField("SORT_NO")
    private Integer sortNo;
    /**
     * 部门状态
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
     * 删除标记
     */
    @TableField("DEL_FLAG")
    @TableLogic
    private Integer delFlag;


    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptShortName() {
        return deptShortName;
    }

    public void setDeptShortName(String deptShortName) {
        this.deptShortName = deptShortName;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public String getDeptFramId() {
        return deptFramId;
    }

    public void setDeptFramId(String deptFramId) {
        this.deptFramId = deptFramId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getDeputyLeader() {
        return deputyLeader;
    }

    public void setDeputyLeader(String deputyLeader) {
        this.deputyLeader = deputyLeader;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDeptGrade() {
        return deptGrade;
    }

    public void setDeptGrade(Integer deptGrade) {
        this.deptGrade = deptGrade;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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
        return this.deptId;
    }

    @Override
    public String toString() {
        return "SystemDept{" +
                ", deptId=" + deptId +
                ", parentId=" + parentId +
                ", deptName=" + deptName +
                ", deptShortName=" + deptShortName +
                ", deptType=" + deptType +
                ", deptFramId=" + deptFramId +
                ", orgId=" + orgId +
                ", deptDesc=" + deptDesc +
                ", leader=" + leader +
                ", deputyLeader=" + deputyLeader +
                ", telPhone=" + telPhone +
                ", address=" + address +
                ", deptGrade=" + deptGrade +
                ", areaCode=" + areaCode +
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
