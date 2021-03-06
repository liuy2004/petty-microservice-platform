package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 资源信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-05-02
 */
@TableName("system_resource")
public class SystemResource extends Model<SystemResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("UUID")
    private String uuid;
    /**
     * 唯一标识符
     */
    @TableField("RESOURCE_CODE")
    private String resourceCode;
    /**
     * 菜单/按钮名称
     */
    @TableField("RESOURCE_NAME")
    private String resourceName;
    /**
     * 请求地址
     */
    @TableField("REQUEST_URL")
    private String requestUrl;
    /**
     * 请求方法
     */
    @TableField("REQUEST_METHOD")
    private String requestMethod;
    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;
    /**
     * 菜单/按钮排序号
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
     * 删除标记  @枚举 0-否；1-是
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

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return "SystemResource{" +
        ", uuid=" + uuid +
        ", resourceCode=" + resourceCode +
        ", resourceName=" + resourceName +
        ", requestUrl=" + requestUrl +
        ", requestMethod=" + requestMethod +
        ", remark=" + remark +
        ", sortNo=" + sortNo +
        ", creator=" + creator +
        ", createDate=" + createDate +
        ", modifier=" + modifier +
        ", modifyDate=" + modifyDate +
        ", delFlag=" + delFlag +
        "}";
    }
}
