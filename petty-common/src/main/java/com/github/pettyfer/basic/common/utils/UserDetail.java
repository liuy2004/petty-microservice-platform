package com.github.pettyfer.basic.common.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pettyfer.basic.common.model.basic.DeptInfo;
import com.github.pettyfer.basic.common.model.basic.GroupInfo;
import com.github.pettyfer.basic.common.model.basic.RoleInfo;
import com.github.pettyfer.basic.common.model.basic.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息详情（角色/部门/职位等等）
 *
 * @author Petty
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetail implements Serializable {
    private static final long serialVersionUID = 7393139301770902436L;

    /**
     * 当前用户信息
     */
    private UserInfo userInfo;
    /**
     * 当前用户角色信息
     */
    private List<RoleInfo> roleInfos = new ArrayList<>();

    /**
     * 当前用户部门信息
     */
    private DeptInfo deptInfo;

    /**
     * 当前用户用户组信息
     */
    private List<GroupInfo> groupInfos = new ArrayList<>();
}
