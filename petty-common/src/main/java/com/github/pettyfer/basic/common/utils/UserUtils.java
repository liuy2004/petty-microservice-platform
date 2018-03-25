package com.github.pettyfer.basic.common.utils;

import com.github.pettyfer.basic.common.constant.CommonConstant;
import com.github.pettyfer.basic.common.context.BaseContextHandler;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import sun.security.provider.certpath.UntrustedChecker;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Petty
 * 用户基础信息解析
 */
@Slf4j
public class UserUtils {
    private static final String KEY_USER = "user";

    /**
     * 获取请求中token
     *
     * @param httpServletRequest request
     * @return token
     */
    public static String getToken(HttpServletRequest httpServletRequest) {
        String authorization = httpServletRequest.getHeader(CommonConstant.REQUEST_HEADER);
        return StringUtils.substringAfter(authorization, CommonConstant.TOKEN_SPLIT);
    }

    /**
     * 通过请求头中的Jwt Token获取用户信息
     *
     * @param request
     * @return
     */
    public static String getUserName(HttpServletRequest request) {
        String username = "";
        String authorization = request.getHeader(CommonConstant.REQUEST_HEADER);
        if (StringUtils.isEmpty(authorization)) {
            return username;
        }
        String token = StringUtils.substringAfter(authorization, CommonConstant.TOKEN_SPLIT);
        if (StringUtils.isEmpty(token)) {
            return username;
        }
        String key = Base64.getEncoder().encodeToString(CommonConstant.SIGN_KEY.getBytes());
        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            username = claims.get("user_name").toString();
        } catch (Exception ex) {
            log.error("Username resolve exception,token:{},key:{}", token, key);
        }
        return username;
    }

    /**
     * 通过token 获取用户名
     *
     * @param authorization
     * @return
     */
    public static String getUserName(String authorization) {
        String username = "";
        String token = StringUtils.substringAfter(authorization, CommonConstant.TOKEN_SPLIT);
        if (StringUtils.isEmpty(token)) {
            return username;
        }
        String key = Base64.getEncoder().encodeToString(CommonConstant.SIGN_KEY.getBytes());
        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            username = claims.get("user_name").toString();
        } catch (Exception ex) {
            log.error("Username resolve exception,token:{},key:{}", token, key);
        }
        return username;
    }

    /**
     * 直接根据请求头中的Token解析角色信息
     *
     * @param httpServletRequest
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<LinkedHashMap<String,String>> getRole(HttpServletRequest httpServletRequest) {
        String token = getToken(httpServletRequest);
        String key = Base64.getEncoder().encodeToString(CommonConstant.SIGN_KEY.getBytes());
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return (List<LinkedHashMap<String,String>>) claims.get("authorities");
    }


    /**
     * 设置用户信息
     *
     * @param username 用户名
     */
    public static void setUser(String username) {
        BaseContextHandler.setUser(username);
        MDC.put(KEY_USER, username);
    }

    /**
     * 从threadlocal 获取用户名
     *
     * @return 用户名
     */

    public static String getUser() {
        return BaseContextHandler.getUser();
    }

    /**
     * 如果没有登录，返回null
     *
     * @return 用户名
     */
    public static String getUserName() {
        return BaseContextHandler.getUser();
    }

    public static void clearAllInfo() {
        BaseContextHandler.remove();
        MDC.remove(KEY_USER);
    }
}
