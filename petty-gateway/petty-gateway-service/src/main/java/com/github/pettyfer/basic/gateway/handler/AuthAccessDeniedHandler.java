package com.github.pettyfer.basic.gateway.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pettyfer.basic.common.constant.CommonConstant;
import com.github.pettyfer.basic.common.constant.SecurityConstant;
import com.github.pettyfer.basic.common.exception.access.DeniedException;
import com.github.pettyfer.basic.common.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author Petty
 * @date 2018年4月11日
 * 权限拦截返回信息
 */
@Slf4j
@Component
public class AuthAccessDeniedHandler extends OAuth2AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    @Autowired
    public AuthAccessDeniedHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * @param request               request
     * @param response              response
     * @param accessDeniedException 禁止访问异常
     * @throws IOException      IOException
     * @throws ServletException ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info(SecurityConstant.AUTHORIZATION_FAILURES);
        response.setCharacterEncoding(CommonConstant.UTF8);
        response.setContentType(CommonConstant.CONTENT_TYPE);
        BaseResponse<String> result = new BaseResponse<>(new DeniedException(SecurityConstant.AUTHORIZATION_FAILURES));
        response.setStatus(HttpStatus.SC_FORBIDDEN);
        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString(result));
    }
}
