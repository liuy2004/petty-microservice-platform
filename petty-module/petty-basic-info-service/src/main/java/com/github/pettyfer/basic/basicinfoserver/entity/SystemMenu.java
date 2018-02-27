package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 菜单信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-27
 */
@TableName("system_menu")
public class SystemMenu extends Model<SystemMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId("MENU_ID")
    private String menuId;
    /**
     * 菜单/按钮编码
     */
    @TableField("CODE")
    private String code;
    /**
     * 父节点
     */
    @TableField("PARENT_CODE")
    private String parentCode;
    /**
     * 菜单/按钮名称
     */
    @TableField("MENU_NAME")
    private String menuName;
    /**
     * 菜单路径
     */
    @TableField("HREF")
    private String href;
    /**
     * 目标窗口@字典 mainFrame-当前窗口，_blank-新窗口
     */
    @TableField("TARGET")
    private String target;
    /**
     * 图标
     */
    @TableField("ICON")
    private String icon;
    /**
     * 是否启用 @枚举 0-否；1-是
     */
    @TableField("IS_SHOW")
    private Integer isShow;
    /**
     * 按钮标识
     */
    @TableField("PERMISSION")
    private String permission;
    /**
     * 类型 @枚举 1-菜单；2-按钮；3-数据权限
     */
    @TableField("MENU_TYPE")
    private Integer menuType;
    /**
     * 是否隐藏@枚举 0-否；1-是
     */
    @TableField("IS_HIDDEN")
    private Integer isHidden;
    /**
     * 是否第三方@枚举 0-否；1-是
     */
    @TableField("IS_EXTERNAL")
    private Integer isExternal;
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
    private Integer delFlag;


    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(Integer isExternal) {
        this.isExternal = isExternal;
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
        return this.menuId;
    }

    @Override
    public String toString() {
        return "SystemMenu{" +
                ", menuId=" + menuId +
                ", code=" + code +
                ", parentCode=" + parentCode +
                ", menuName=" + menuName +
                ", href=" + href +
                ", target=" + target +
                ", icon=" + icon +
                ", isShow=" + isShow +
                ", permission=" + permission +
                ", menuType=" + menuType +
                ", isHidden=" + isHidden +
                ", isExternal=" + isExternal +
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
