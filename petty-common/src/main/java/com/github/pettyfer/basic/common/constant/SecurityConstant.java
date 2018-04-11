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
    String AUTHORIZATION_FAILURES = "Authorization failures";

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
     * 默认的处理验证码的url前缀
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 手机号的处理验证码的url前缀
     */
    String MOBILE_VALIDATE_CODE_URL_PREFIX = "/smsCode";

    /**
     * 默认生成图形验证码宽度
     */
    String DEFAULT_IMAGE_WIDTH = "150";

    /**
     * 默认生成图像验证码高度
     */
    String DEFAULT_IMAGE_HEIGHT = "32";

    /**
     * 默认生成图形验证码长度
     */
    String DEFAULT_IMAGE_LENGTH = "4";

    /**
     * 默认生成图形验证码过期时间
     */
    int DEFAULT_IMAGE_EXPIRE = 60;
    /**
     * 边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.
     */
    String DEFAULT_COLOR_FONT = "black";

    /**
     * 图片边框
     */
    String DEFAULT_IMAGE_BORDER = "no";
    /**
     * 默认图片间隔
     */
    String DEFAULT_CHAR_SPACE = "5";

    /**
     * 默认保存code的前缀
     */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY";
    /**
     * 验证码文字大小
     */
    String DEFAULT_IMAGE_FONT_SIZE = "30";

    /**
     * token-uservo
     */
    String TOKEN_USER_DETAIL = "token-user-detail";

}
