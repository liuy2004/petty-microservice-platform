package com.github.pettyfer.basic.basicinfoserver.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author Pettyfer
 * @since 2018-05-02
 */
@TableName("system_user")
public class SystemUser extends Model<SystemUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("UUID")
    private String uuid;
    /**
     * 用户唯一码
     */
    @TableField("USER_CODE")
    private String userCode;
    /**
     * 用户名
     */
    @TableField("USER_NAME")
    private String userName;
    /**
     * 密码
     */
    @TableField("USER_PWD")
    private String userPwd;
    /**
     * 名称
     */
    @TableField("FULL_NAME")
    private String fullName;
    /**
     * 性别
     */
    @TableField("USER_SEX")
    private String userSex;
    /**
     * 出生日期
     */
    @TableField("USER_BIRTHDAY")
    private String userBirthday;
    /**
     * 入职日期
     */
    @TableField("IN_DATE")
    private String inDate;
    /**
     * 用户头像地址
     */
    @TableField("PHOTO")
    private String photo;
    /**
     * 工号
     */
    @TableField("USER_NUM")
    private String userNum;
    /**
     * 邮件
     */
    @TableField("EMAIL")
    private String email;
    /**
     * QQ号
     */
    @TableField("QQ_NUM")
    private String qqNum;
    /**
     * 电话号码
     */
    @TableField("USER_TEL")
    private String userTel;
    /**
     * 用户地址
     */
    @TableField("USER_ADDR")
    private String userAddr;
    /**
     * 用户描述
     */
    @TableField("USER_DESC")
    private String userDesc;
    /**
     * 手机号码
     */
    @TableField("USER_PHONE_TEL")
    private String userPhoneTel;
    /**
     * 用户来源
     */
    @TableField("USER_SOURCE")
    private String userSource;
    /**
     * 证件类型
     */
    @TableField("USER_IDEN_TYPE")
    private Integer userIdenType;
    /**
     * 证件号
     */
    @TableField("USER_IDEN")
    private String userIden;
    /**
     * 管理员类型
     */
    @TableField("IS_ADMIN")
    private Integer isAdmin;
    /**
     * 是否启用  @枚举  0:否；1:是
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
     * 删除标记  @枚举  0:否；1:是
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getUserPhoneTel() {
        return userPhoneTel;
    }

    public void setUserPhoneTel(String userPhoneTel) {
        this.userPhoneTel = userPhoneTel;
    }

    public String getUserSource() {
        return userSource;
    }

    public void setUserSource(String userSource) {
        this.userSource = userSource;
    }

    public Integer getUserIdenType() {
        return userIdenType;
    }

    public void setUserIdenType(Integer userIdenType) {
        this.userIdenType = userIdenType;
    }

    public String getUserIden() {
        return userIden;
    }

    public void setUserIden(String userIden) {
        this.userIden = userIden;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
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
        return "SystemUser{" +
        ", uuid=" + uuid +
        ", userCode=" + userCode +
        ", userName=" + userName +
        ", userPwd=" + userPwd +
        ", fullName=" + fullName +
        ", userSex=" + userSex +
        ", userBirthday=" + userBirthday +
        ", inDate=" + inDate +
        ", photo=" + photo +
        ", userNum=" + userNum +
        ", email=" + email +
        ", qqNum=" + qqNum +
        ", userTel=" + userTel +
        ", userAddr=" + userAddr +
        ", userDesc=" + userDesc +
        ", userPhoneTel=" + userPhoneTel +
        ", userSource=" + userSource +
        ", userIdenType=" + userIdenType +
        ", userIden=" + userIden +
        ", isAdmin=" + isAdmin +
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
