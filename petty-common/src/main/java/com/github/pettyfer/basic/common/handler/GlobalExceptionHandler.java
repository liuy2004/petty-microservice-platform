package com.github.pettyfer.basic.common.handler;

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
     * 处理BaseException异常
     *
     * @param request
     * @param response
     * @param ex
     * @return
     * @link com.github.pettyfer.basic.common.exception.BaseException
     */
    @ExceptionHandler(BaseRuntimeException.class)
    public BaseResponse baseExceptionHandler(HttpServletRequest request, HttpServletResponse response, BaseRuntimeException ex) {
        log.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage(), request.getRequestURI());
    }

    /**
     * 处理Exception异常
     *
     * @param request
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public BaseResponse otherExceptionHandler(HttpServletRequest request, HttpServletResponse response, BaseException ex) {
        log.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage(), request.getRequestURI());
    }
}
