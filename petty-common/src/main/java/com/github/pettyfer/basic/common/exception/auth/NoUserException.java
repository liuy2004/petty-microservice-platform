package com.github.pettyfer.basic.common.exception.auth;

import com.github.pettyfer.basic.common.constant.CommonConstant;
import com.github.pettyfer.basic.common.exception.BaseRuntimeException;

/**
 * 没有找到从Token中解析出来的用户信息时，抛出该异常
 * @author Petty
 * @version 1.0
 * {@link com.github.pettyfer.basic.common.exception.BaseRuntimeException }
 */
public class NoUserException extends BaseRuntimeException {

    private static final long serialVersionUID = 1743414082337284940L;

    public NoUserException(String message) {
        super(message,CommonConstant.EX_NO_USER);
    }
}
