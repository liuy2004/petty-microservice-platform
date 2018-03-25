package com.github.pettyfer.basic.common.utils;

import com.github.pettyfer.basic.common.context.BaseContextHandler;
import com.github.pettyfer.basic.common.feign.DeptInfoService;
import com.github.pettyfer.basic.common.feign.GroupInfoService;
import com.github.pettyfer.basic.common.feign.RoleInfoService;
import com.github.pettyfer.basic.common.feign.UserInfoService;
import com.github.pettyfer.basic.common.model.DeptInfo;
import com.github.pettyfer.basic.common.model.GroupInfo;
import com.github.pettyfer.basic.common.model.RoleInfo;
import com.github.pettyfer.basic.common.model.UserInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Petty
 */
@Slf4j
public class SysUtils {

    private static UserInfoService userInfoService = SpringContextHolder.getBean(UserInfoService.class);

    private static DeptInfoService deptInfoService = SpringContextHolder.getBean(DeptInfoService.class);

    private static RoleInfoService roleInfoService = SpringContextHolder.getBean(RoleInfoService.class);

    private static GroupInfoService groupInfoService = SpringContextHolder.getBean(GroupInfoService.class);

    /**
     * 获取用户详情
     *
     * @return
     */
    public static SysDetail getUserDetail() {
        SysDetail sysDetail = new SysDetail();
        String username = BaseContextHandler.getUser();
        UserInfo userInfo = userInfoService.findUserInfoByUsername(username);
        List<RoleInfo> roleInfos = roleInfoService.findRoleInfoByUserId(userInfo.getUserId());
        DeptInfo deptInfo = deptInfoService.findDeptInfoByUserId(userInfo.getUserId());
        List<GroupInfo> groupInfos = groupInfoService.findGroupInfoByUserId(userInfo.getUserId());
        sysDetail.setUserInfo(userInfo);
        sysDetail.setDeptInfo(deptInfo);
        sysDetail.setGroupInfos(groupInfos);
        sysDetail.setRoleInfos(roleInfos);
        return sysDetail;
    }
}
