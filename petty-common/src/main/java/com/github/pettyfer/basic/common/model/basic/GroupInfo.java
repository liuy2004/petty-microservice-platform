package com.github.pettyfer.basic.common.model.basic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户组
 *
 * @author Petty
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupInfo implements Serializable {
    private static final long serialVersionUID = 4276507548530306822L;
    private String groupCode;
    private String groupName;
    private String parentCode;
    private Integer groupType;
}
