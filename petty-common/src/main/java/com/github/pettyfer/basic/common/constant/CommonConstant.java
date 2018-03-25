package com.github.pettyfer.basic.common.constant;


/**
 * @author Petty
 */
public interface CommonConstant {

    int NO_LOGIN = 403;

    int SUCCESS = 200;

    int FAIL = 500;

    int NO_PERMISSION = 403;

    /**
     * 没有权限
     */
    Integer EX_TOKEN_ERROR_CODE = 403;
    Integer EX_OTHER_CODE = 500;
    /**
     * Jwt加密/解密凭据
     */
    String SIGN_KEY = "PETTYFER";
    /**
     * 解析Token分隔符
     */
    String TOKEN_SPLIT = "Bearer ";
    /**
     * 请求头
     */
    String REQUEST_HEADER = "Authorization";
    /**
     * 用户无效
     */
    Integer STATUS_INVALID = 1;
    /**
     * 用户正常
     */
    Integer STATUS_NORMAL = 0;
    /**
     * 用户锁定
     */
    Integer STATUS_LOCK = 9;
    String DEL_FLAG = "del_flag";
    String CONTENT_TYPE = "application/json; charset=utf-8";
    /**
     * 编码
     */
    String UTF8 = "UTF-8";

    String BASIC_USERNAME_CONTEXT = "basic_username_context";
}
