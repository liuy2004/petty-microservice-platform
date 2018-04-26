package com.github.pettyfer.basic.basicinfoserver.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 菜单信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-04-25
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
     * 父节点
     */
    @TableField("PARENT_ID")
    private String parentId;
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
     * 图标
     */
    @TableField("ICON")
    private String icon;
    /**
     * 是否启用 @枚举 0-否；1-是
     */
    @TableField("IS_SHOW")
    private BigDecimal isShow;
    /**
     * 按钮标识
     */
    @TableField("PERMISSION")
    private String permission;
    /**
     * 类型 @枚举 1-菜单；2-按钮；3-数据权限
     */
    @TableField("MENU_TYPE")
    private BigDecimal menuType;
    /**
     * 是否隐藏@枚举 0-否；1-是
     */
    @TableField("IS_HIDDEN")
    private BigDecimal isHidden;
    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;
    /**
     * 菜单/按钮排序号
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
     * 删除标记  @枚举 0-否；1-是
     */
    @TableField("DEL_FLAG")
    @TableLogic
    private BigDecimal delFlag;


    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public BigDecimal getIsShow() {
        return isShow;
    }

    public void setIsShow(BigDecimal isShow) {
        this.isShow = isShow;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public BigDecimal getMenuType() {
        return menuType;
    }

    public void setMenuType(BigDecimal menuType) {
        this.menuType = menuType;
    }

    public BigDecimal getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(BigDecimal isHidden) {
        this.isHidden = isHidden;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return this.menuId;
    }

    @Override
    public String toString() {
        return "SystemMenu{" +
        ", menuId=" + menuId +
        ", parentId=" + parentId +
        ", menuName=" + menuName +
        ", href=" + href +
        ", icon=" + icon +
        ", isShow=" + isShow +
        ", permission=" + permission +
        ", menuType=" + menuType +
        ", isHidden=" + isHidden +
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
