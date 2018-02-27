package com.github.pettyfer.basic.basicinfoserver.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户岗位信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-27
 */
@TableName("system_position")
public class SystemPosition extends Model<SystemPosition> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("POSITION_ID")
    private String positionId;
    /**
     * 部门CODE
     */
    @TableField("DEPT_CODE")
    private String deptCode;
    /**
     * 岗位代码
     */
    @TableField("CODE")
    private String code;
    /**
     * 岗位标识
     */
    @TableField("POSITION_CODE")
    private String positionCode;
    /**
     * 岗位名称
     */
    @TableField("POSITION_NAME")
    private String positionName;
    /**
     * 是否启用  @枚举  0:否；1:是
     */
    @TableField("STATUS")
    private BigDecimal status;
    /**
     * 排序号
     */
    @TableField("SORT_NO")
    private BigDecimal sortNo;
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
    private BigDecimal delFlag;


    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public BigDecimal getSortNo() {
        return sortNo;
    }

    public void setSortNo(BigDecimal sortNo) {
        this.sortNo = sortNo;
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

    public BigDecimal getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(BigDecimal delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.positionId;
    }

    @Override
    public String toString() {
        return "SystemPosition{" +
        ", positionId=" + positionId +
        ", deptCode=" + deptCode +
        ", code=" + code +
        ", positionCode=" + positionCode +
        ", positionName=" + positionName +
        ", status=" + status +
        ", sortNo=" + sortNo +
        ", creator=" + creator +
        ", createDate=" + createDate +
        ", modifier=" + modifier +
        ", modifyDate=" + modifyDate +
        ", delFlag=" + delFlag +
        "}";
    }
}
