package com.github.pettyfer.basic.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色信息
 * @author Petty
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private String roleId;
    private String roleName;
    private String roleType;
    private Integer roleStatus;
    private Integer sortNo;
}
