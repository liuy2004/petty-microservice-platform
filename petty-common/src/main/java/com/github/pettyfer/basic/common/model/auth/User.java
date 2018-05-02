package com.github.pettyfer.basic.common.model.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息，用户授权服务判断登陆有效信息
 * PS:包含用户密码
 *
 * @author Petty
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -2924404879928203710L;
    private String userCode;
    private String userName;
    private String userPwd;
    private String fullName;
    private Integer sortNo;
    private Integer isAdmin;
    private Integer status;
    private Integer delFlag;
    List<Role> roleList = new ArrayList<>();
}
