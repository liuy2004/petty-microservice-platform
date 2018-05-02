package com.github.pettyfer.basic.common.model.basic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户基础信息模型，用户获取用户基础信息
 * PS:不包含密码等敏感数据
 *
 * @author Petty
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 6703721639017427276L;
    private String userCode;
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
