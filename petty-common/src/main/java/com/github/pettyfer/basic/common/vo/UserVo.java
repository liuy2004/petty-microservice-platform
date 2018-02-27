package com.github.pettyfer.basic.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息
 * @author Petty
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo implements Serializable {
    private String userId;
    private String userName;
    private String userPwd;
    private String fullName;
    private BigDecimal sortNo;
    private BigDecimal isAdmin;
    private BigDecimal status;
    private String creator;
    private String createDate;
    private String modifier;
    private String modifyDate;
    private BigDecimal delFlag;
    List<RoleVo> roleVoList = new ArrayList<>();
}
