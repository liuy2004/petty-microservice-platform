package com.github.pettyfer.basic.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息
 * @author Petty
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String userId;
    private String userName;
    private String userPwd;
    private String fullName;
    private Integer sortNo;
    private Integer isAdmin;
    private Integer status;
    private String creator;
    private String createDate;
    private String modifier;
    private String modifyDate;
    private Integer delFlag;
    List<Role> roleList = new ArrayList<>();
}
