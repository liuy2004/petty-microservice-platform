package com.github.pettyfer.basic.auth.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.util.CollectionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

/**
 * 用户登陆成功之后进行跳转
 * 注：该处不是跳转至授权页面而是跳转至应用管理
 *
 * @author Petty
 * @version 1.0.0
 * @since 2018年3月11日
 */
public class SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        if (hasRole(authentication.getAuthorities(), "ROLE_ADMIN")) {
            setDefaultTargetUrl("/admin/dashboard");
        } else if (hasRole(authentication.getAuthorities(), "ROLE_DEVELOPER")) {
            setDefaultTargetUrl("/console/dashboard");
        } else if (hasRole(authentication.getAuthorities(), "ROLE_USER")) {
            setDefaultTargetUrl("/user/dashboard");
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }

    private boolean hasRole(Collection<? extends GrantedAuthority> authorities, String role) {
        if (CollectionUtils.isEmpty(authorities)) {
            return false;
        }
        GrantedAuthority authority = authorities.stream()
                .filter(auth -> auth.getAuthority().equals(role)).findAny()
                .orElse(null);
        return Objects.nonNull(authority);
    }

}
