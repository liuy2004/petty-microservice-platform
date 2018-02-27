package com.github.pettyfer.basic.common.constant;


/**
 * @author Petty
 */
public interface CommonConstant {
    /**
     * token请求头名称
     */
    String REQUEST_HEADER = "Authorization";

    /**
     * token分割符
     */
    String TOKEN_SPLIT = "Bearer ";

    /**
     * jwt签名
     */
    String SIGN_KEY = "PETTYFER";
    /**
     * 删除
     */
    String STATUS_DEL = "1";
    /**
     * 正常
     */
    String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    String STATUS_LOCK = "9";
    /**
     * 删除标记
     */
    String DEL_FLAG = "del_flag";
    /**
     * JSON 资源
     */
    String CONTENT_TYPE = "application/json; charset=utf-8";
}
