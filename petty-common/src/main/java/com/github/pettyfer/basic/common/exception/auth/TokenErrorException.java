package com.github.pettyfer.basic.common.exception.auth;


import com.github.pettyfer.basic.common.constant.CommonConstant;
import com.github.pettyfer.basic.common.exception.BaseException;

/**
 * Token无效或者没有抛出该异常
 * @author Petty
 * @version 1.0
 * {@link com.github.pettyfer.basic.common.exception.BaseException }
 */
public class TokenErrorException extends BaseException {
    private static final long serialVersionUID = 8827019082477401466L;

    public TokenErrorException(String message) {
        super(message, CommonConstant.EX_TOKEN_ERROR_CODE);
    }
}
