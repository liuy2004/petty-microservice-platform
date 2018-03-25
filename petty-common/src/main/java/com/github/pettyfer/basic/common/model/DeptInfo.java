package com.github.pettyfer.basic.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户所属部门
 * @author Petty
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptInfo implements Serializable{
    private static final long serialVersionUID = 4257669635468768869L;

    private String deptName;
}