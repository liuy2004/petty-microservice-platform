package com.github.pettyfer.basic.common.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.pettyfer.basic.common.constant.CommonConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Petty
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -3246273238796974462L;
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

    public BaseResponse(Throwable e, int statusCode) {
        super();
        this.message = e.getMessage();
        this.status = statusCode;
    }
}
