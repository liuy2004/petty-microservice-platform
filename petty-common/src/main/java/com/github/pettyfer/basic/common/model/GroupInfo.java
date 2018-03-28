package com.github.pettyfer.basic.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户组
 *
 * @author Petty
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupInfo implements Serializable {
    private static final long serialVersionUID = 4276507548530306822L;
    private String groupId;
    private String groupName;
    private String parentId;
    private BigDecimal groupType;
}
