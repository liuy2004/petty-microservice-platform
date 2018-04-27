package com.github.pettyfer.basic.basicinfoserver.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 菜单信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-04-27
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
     * 路由地址
     */
    @TableField("ROUTER_PATH")
    private String routerPath;
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
    private Integer delFlag;


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

    public String getRouterPath() {
        return routerPath;
    }

    public void setRouterPath(String routerPath) {
        this.routerPath = routerPath;
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
        ", parentId=" + parentId +
        ", menuName=" + menuName +
        ", routerPath=" + routerPath +
        ", icon=" + icon +
        ", isShow=" + isShow +
        ", permission=" + permission +
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
