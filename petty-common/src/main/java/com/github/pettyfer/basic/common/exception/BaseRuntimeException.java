package com.github.pettyfer.basic.common.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 自定义RuntimeException
 * @author Petty
 * @date 2018年2月24日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRuntimeException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -8390390631837103313L;
    private int status = 200;

    public BaseRuntimeException(String message, int status) {
        super(message);
        this.status = status;
    }

    public BaseRuntimeException(String message) {
        super(message);
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseRuntimeException(Throwable cause) {
        super(cause);
    }

    public BaseRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
