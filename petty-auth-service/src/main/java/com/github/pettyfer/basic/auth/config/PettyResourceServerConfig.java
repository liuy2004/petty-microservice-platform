package com.github.pettyfer.basic.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 * 用户资源服务
 *
 * @author Petty
 */
@Configuration
@EnableResourceServer
public class PettyResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public PettyResourceServerConfig(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .requestMatchers()
                .antMatchers("/resource/**")
                .and().authorizeRequests()
                // todo add permission check
                .antMatchers("/monitoring/**").permitAll()
                .antMatchers("/resource/**")
                .authenticated();
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