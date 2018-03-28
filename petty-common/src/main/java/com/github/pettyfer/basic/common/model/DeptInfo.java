package com.github.pettyfer.basic.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户所属部门
 *
 * @author Petty
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptInfo implements Serializable {
    private static final long serialVersionUID = 4257669635468768869L;
    private String deptId;
    private String parentId;
    private String deptName;
    private String deptShortName;
    private String deptType;
    private String deptFramId;
    private String orgId;
    private String deptDesc;
    private String leader;
    private String deputyLeader;
    private String telPhone;
    private String address;
    private BigDecimal deptGrade;
    private String areaCode;
}
