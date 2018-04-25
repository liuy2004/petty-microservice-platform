package com.github.pettyfer.basic.common.constant;

/**
 * @author Petty
 */
public interface SecurityConstant {
    /**
     * 基础用户角色
     */
    String BASE_ROLE = "ROLE_USER";
    /**
     * 管理员角色
     */
    String ADMIN_ROLE = "ROLE_ADMIN";
    /**
     * 开发者角色
     */
    String DEVELOPER_ROLE = "ROLE_DEVELOPER";
    /**
     * oauth 授权码模式
     */
    String AUTHORIZATION_CODE = "authorization_code";

    /**
     * 资源授权失败或没有授权记录
     */
    String AUTHORIZATION_FAILURES = "403 Forbidden";

    /**
     * 客户端授权模式
     */
    String CLIENT = "client_credentials";
    /**
     * 密码模式
     */
    String PASSWORD = "password";
    /**
     * 刷新token
     */
    String REFRESH_TOKEN = "refresh_token";

    String MOBILE_TOKEN_URL = "/mobile/token";


    /**
     * token
     */
    String TOKEN_USER_DETAIL = "token-user-detail";


    /**
     * 验证码Redis储存Key
     */
    String VALIDATE_CODE_KEY = "validate-code-key";

    /**
     * 验证码过期时间
     */
    Integer VALIDATE_CODE_EXPIRY = 60;

}
