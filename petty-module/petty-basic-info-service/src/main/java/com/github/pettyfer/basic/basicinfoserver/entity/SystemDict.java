package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统字典信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-05-02
 */
@TableName("system_dict")
public class SystemDict extends Model<SystemDict> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("UUID")
    private String uuid;
    /**
     * 字典唯一码
     */
    @TableField("DICT_CODE")
    private String dictCode;
    /**
     * 类型
     */
    @TableField("DICT_TYPE")
    private String dictType;
    /**
     * 字典键
     */
    @TableField("DICT_KEY")
    private String dictKey;
    /**
     * 字典值
     */
    @TableField("DICT_VALUE")
    private String dictValue;
    /**
     * 字典描述
     */
    @TableField("DICT_DESC")
    private String dictDesc;
    /**
     * 父级编码
     */
    @TableField("PARENT_CODE")
    private String parentCode;
    /**
     * 是否默认显示值  @枚举 1、是，0、否
     */
    @TableField("IS_DEFAULT")
    private Integer isDefault;
    /**
     * 是否启用 @枚举  0:否  1:是
     */
    @TableField("STATUS")
    private Integer status;
    /**
     * 排序号
     */
    @TableField("SORT_NO")
    private Integer sortNo;
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
     * 删除标记 @枚举 0-否  1-是
     */
    @TableField("DEL_FLAG")
    @TableLogic
    private Integer delFlag;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "SystemDict{" +
        ", uuid=" + uuid +
        ", dictCode=" + dictCode +
        ", dictType=" + dictType +
        ", dictKey=" + dictKey +
        ", dictValue=" + dictValue +
        ", dictDesc=" + dictDesc +
        ", parentCode=" + parentCode +
        ", isDefault=" + isDefault +
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
