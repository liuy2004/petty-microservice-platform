package com.github.pettyfer.basic.auth.config;

import com.github.pettyfer.basic.auth.utils.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 自定义Jwt内容
 * @author Petty
 * @date 2018年3月4日
 */
public class CustomerAccessTokenConverter extends DefaultAccessTokenConverter{
    public CustomerAccessTokenConverter() {
        super.setUserTokenConverter(new CustomerUserAuthenticationConverter());
    }


    private class CustomerUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

        @Override
        public Map<String, ?> convertUserAuthentication(Authentication authentication) {
            LinkedHashMap<String, Object> response = new LinkedHashMap<>();
            response.put("user_name", authentication.getName());
            response.put("name", ((UserDetailsImpl) authentication.getPrincipal()).getUsername());
            if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
                response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
            }
            return response;
        }
    }
}
