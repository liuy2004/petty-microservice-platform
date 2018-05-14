package com.github.pettyfer.basic.common.context;

import com.github.pettyfer.basic.common.constant.CommonConstant;
import com.github.pettyfer.basic.common.model.auth.User;

/**
 * 用户会话上下文
 *
 * @author Petty
 */
public class SessionContext extends BaseContextHandler {

    public static void setUser(User user) {
        set(CommonConstant.BASIC_USER_CONTEXT, user);
    }

    public static User getUser() {
        Object user = get(CommonConstant.BASIC_USER_CONTEXT);
        return user == null ? null : (User) user;
    }

}
