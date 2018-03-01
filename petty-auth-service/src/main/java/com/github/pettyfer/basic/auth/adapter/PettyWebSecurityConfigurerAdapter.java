package com.github.pettyfer.basic.auth.adapter;

import com.github.pettyfer.basic.auth.provider.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Petty
 */

public class PettyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.antMatcher("/oauth/**")
                .authorizeRequests()
                .antMatchers("/oauth/index").permitAll()
                .antMatchers("/oauth/token").permitAll()
                .antMatchers("/oauth/check_token").permitAll()
                .antMatchers("/oauth/confirm_access").permitAll()
                .antMatchers("/oauth/error").permitAll()
                .antMatchers("/oauth/my_approval_page").permitAll()
                .antMatchers("/oauth/my_error_page").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/oauth/login")
                .loginProcessingUrl("/oauth/index");
    }
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;
}
