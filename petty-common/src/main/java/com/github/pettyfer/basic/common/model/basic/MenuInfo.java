package com.github.pettyfer.basic.common.model.basic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Petty
 * @date 2018/4/26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuInfo implements Serializable {
    private static final long serialVersionUID = 7593984561438329435L;
    private String menuId;
    private String parentId;
    private String menuName;
    private String href;
    private String icon;
    private Integer isShow;
    private String permission;
    private String remark;
    private String creator;
    private String createDate;
    private String modifier;
    private String modifyDate;
}
