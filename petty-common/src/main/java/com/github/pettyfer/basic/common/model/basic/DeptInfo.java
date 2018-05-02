package com.github.pettyfer.basic.common.model.basic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户所属部门
 *
 * @author Petty
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeptInfo implements Serializable {
    private static final long serialVersionUID = 4257669635468768869L;
    private String deptCode;
    private String parentCode;
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
    private Integer deptGrade;
    private String areaCode;
}
