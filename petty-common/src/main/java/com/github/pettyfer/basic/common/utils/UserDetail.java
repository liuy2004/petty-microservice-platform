package com.github.pettyfer.basic.common.utils;

import com.github.pettyfer.basic.common.entity.Role;
import com.github.pettyfer.basic.common.model.DeptInfo;
import com.github.pettyfer.basic.common.model.GroupInfo;
import com.github.pettyfer.basic.common.model.RoleInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息详情（角色/部门/职位等等）
 * @author Petty
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail implements Serializable {
    private String userId;
    private String userName;
    private String fullName;
    private List<RoleInfo> roleInfos = new ArrayList<>();
    private DeptInfo deptInfo;
    private List<GroupInfo> groupInfos = new ArrayList<>();
}
