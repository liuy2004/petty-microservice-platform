package com.github.pettyfer.basic.oauth.translator;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.common.exceptions.UnsupportedResponseTypeException;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;

/**
 * spring security 异常转化器
 * 默认的国际化的异常信息在 spring-security-code下messages_zh_CN
 * LdapAuthenticationProvider.badCredentials=坏的凭证
 * LdapAuthenticationProvider.credentialsExpired=用户凭证已过期
 * LdapAuthenticationProvider.disabled=用户已失效
 * LdapAuthenticationProvider.expired=用户帐号已过期
 * LdapAuthenticationProvider.locked=用户帐号已被锁定
 * LdapAuthenticationProvider.emptyUsername=用户名不允许为空
 * LdapAuthenticationProvider.onlySupports=仅仅支持UsernamePasswordAuthenticationToken
 * PasswordComparisonAuthenticator.badCredentials=坏的凭证
 *
 * @author Petty
 */
@Component
public class ResponseExceptionTranslator extends DefaultWebResponseExceptionTranslator {

    public static final String BAD_MSG = "坏的凭证";

    public static final String INVALID_REFRESH_TOKEN = "Invalid refresh token";

    /**
     * @param e spring security内部异常
     * @return 经过处理的异常信息
     * @throws Exception 通用异常
     */
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        OAuth2Exception oAuth2Exception;
        if (e instanceof InvalidGrantException && StringUtils.equals(BAD_MSG, e.getMessage())) {
            oAuth2Exception = new InvalidGrantException("密码错误", e);
        } else if (e instanceof InvalidGrantException && StringUtils.contains(e.getMessage(), INVALID_REFRESH_TOKEN)) {
            oAuth2Exception = new InvalidGrantException("refresh_token失效", e);
        } else if (e instanceof InternalAuthenticationServiceException) {
            oAuth2Exception = new InvalidGrantException("用户名不存在", e);
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            oAuth2Exception = new InvalidGrantException("不支持的请求方式", e);
        } else {
            oAuth2Exception = new UnsupportedResponseTypeException("服务处理异常,请检查请求参数", e);
        }
        return super.translate(oAuth2Exception);
    }
}
