package com.github.pettyfer.basic.common.handler;

import com.github.pettyfer.basic.common.constant.CommonConstant;
import com.github.pettyfer.basic.common.exception.BaseException;
import com.github.pettyfer.basic.common.exception.BaseRuntimeException;
import com.github.pettyfer.basic.common.response.BaseResponse;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller全局异常处理
 *
 * @author Petty
 * @version 1.0.0
 */
@ControllerAdvice("com.github.pettyfer")
@ResponseBody
@Log4j
public class GlobalExceptionHandler {
    /**
     * 处理BaseRuntimeException异常
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param ex       异常
     * @return data
     */
    @ExceptionHandler(BaseRuntimeException.class)
    public BaseResponse baseExceptionHandler(HttpServletRequest request, HttpServletResponse response, BaseRuntimeException ex) {
        log.error(ex.getMessage(), ex);
        response.setStatus(ex.getStatus());
        return new BaseResponse(ex, ex.getStatus());
    }

    /**
     * 处理BaseException异常
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param ex       异常
     * @return data
     */
    @ExceptionHandler(BaseException.class)
    public BaseResponse otherExceptionHandler(HttpServletRequest request, HttpServletResponse response, BaseException ex) {
        log.error(ex.getMessage(), ex);
        response.setStatus(ex.getStatus());
        return new BaseResponse(ex, ex.getStatus());
    }


    /**
     * 处理Exception异常
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param ex       异常
     * @return data
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        log.error(ex.getMessage(), ex);
        response.setStatus(CommonConstant.EX_OTHER_CODE);
        return new BaseResponse(ex, CommonConstant.EX_OTHER_CODE);
    }
}
