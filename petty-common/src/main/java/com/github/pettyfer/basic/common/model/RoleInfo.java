package com.github.pettyfer.basic.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色信息模型
 *
 * @author Petty
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfo implements Serializable {
    private static final long serialVersionUID = 4994910569599395548L;
    private String roleId;
    private String roleName;
    private String roleType;
}
