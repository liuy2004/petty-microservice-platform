package com.github.pettyfer.basic.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 角色信息
 * @author Petty
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto implements Serializable {
    private String roleId;
    private String roleName;
    private String roleType;
    private Integer roleStatus;
    private Integer sortNo;
}
