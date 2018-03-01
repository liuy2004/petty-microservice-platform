package com.github.pettyfer.basic.common.response;

import com.github.pettyfer.basic.common.constant.CommonConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Petty
 */
@Data
public class BaseResponse<T> implements Serializable {

    private String message = "Success";

    private long timestamp = System.currentTimeMillis();

    private int status = CommonConstant.SUCCESS;

    private T data;

    public BaseResponse() {
        super();
    }

    public BaseResponse(T data) {
        super();
        this.data = data;
    }

    public BaseResponse(Throwable e) {
        super();
        this.message = e.getMessage();
        this.status = CommonConstant.FAIL;
    }
}
