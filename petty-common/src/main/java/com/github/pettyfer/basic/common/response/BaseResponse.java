package com.github.pettyfer.basic.common.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Petty
 * @date 2018年2月24日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = -8655755752235388053L;
    private int status = 200;
    private String message;
    private String path;
    private long timestamp;

    public BaseResponse(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = System.currentTimeMillis();
    }
}
