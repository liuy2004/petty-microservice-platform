package com.github.pettyfer.basic.auth.adapter;

import com.github.pettyfer.basic.common.config.FilterUrlsPropertiesConifg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 * 用户资源服务
 *
 * @author Petty
 */
@Configuration
@EnableResourceServer
public class PettyResourceServerAdapter extends ResourceServerConfigurerAdapter {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private FilterUrlsPropertiesConifg filterUrlsPropertiesConifg;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .authorizeRequests();
        for (String url : filterUrlsPropertiesConifg.getAnon()) {
            registry.antMatchers(url).permitAll();
        }
        registry.anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Primary
    @Bean
    public ResourceServerTokenServices resourceServerTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(new RedisTokenStore(redisConnectionFactory));
        tokenServices.setSupportRefreshToken(true);
        return tokenServices;
    }

}