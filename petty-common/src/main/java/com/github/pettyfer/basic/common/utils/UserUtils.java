package com.github.pettyfer.basic.common.utils;

import com.github.pettyfer.basic.common.context.SessionContext;
import com.github.pettyfer.basic.common.exception.auth.UserContextException;
import com.github.pettyfer.basic.common.feign.DeptInfoService;
import com.github.pettyfer.basic.common.feign.GroupInfoService;
import com.github.pettyfer.basic.common.feign.RoleInfoService;
import com.github.pettyfer.basic.common.feign.UserInfoService;
import com.github.pettyfer.basic.common.model.auth.User;
import com.github.pettyfer.basic.common.model.basic.DeptInfo;
import com.github.pettyfer.basic.common.model.basic.GroupInfo;
import com.github.pettyfer.basic.common.model.basic.RoleInfo;
import com.github.pettyfer.basic.common.model.basic.UserInfo;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Petty
 */
@Slf4j
public class UserUtils {

    private static UserInfoService userInfoService = SpringContextHolder.getBean(UserInfoService.class);

    private static DeptInfoService deptInfoService = SpringContextHolder.getBean(DeptInfoService.class);

    private static RoleInfoService roleInfoService = SpringContextHolder.getBean(RoleInfoService.class);

    private static GroupInfoService groupInfoService = SpringContextHolder.getBean(GroupInfoService.class);

    /**
     * 获取用户详情
     *
     * @return
     */
    public static UserDetail getUserDetail() {
        UserDetail userDetail = new UserDetail();
        User user = SessionContext.getUser();
        try{
            Preconditions.checkNotNull(user);
        }catch (Exception e){
            throw new UserContextException("没有获取到用户上下文信息，请使用@UserContext注解解析并增加用户信息上下文");
        }

        UserInfo userInfo = userInfoService.findUserInfoByUsername(user.getUserName());
        List<RoleInfo> roleInfos = roleInfoService.findRoleInfoByUserId(userInfo.getUserCode());
        DeptInfo deptInfo = deptInfoService.findDeptInfoByUserId(userInfo.getUserCode());
        List<GroupInfo> groupInfos = groupInfoService.findGroupInfoByUserId(userInfo.getUserCode());
        userDetail.setUserInfo(userInfo);
        userDetail.setDeptInfo(deptInfo);
        userDetail.setGroupInfos(groupInfos);
        userDetail.setRoleInfos(roleInfos);
        return userDetail;
    }
}
