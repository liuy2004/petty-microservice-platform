package com.github.pettyfer.basic.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户基础信息模型
 * @author Petty
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 6703721639017427276L;
    private String userId;
    private String userName;
    private String fullName;
    private String userSex;
    private String userBirthday;
    private String inDate;
    private String photo;
    private String userNum;
    private String email;
    private String qqNum;
    private String userTel;
    private String userAddr;
    private String userDesc;
    private String userPhoneTel;
    private Integer userSource;
    private Integer userIdenType;
    private String userIden;
    private Integer isAdmin;
    private Integer status;
}
