package com.github.pettyfer.basic.auth.config;

import com.github.pettyfer.basic.auth.handler.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

/**
 * 配置用户验证
 *
 * @author Petty
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(WebSecurity webSecurity) {
        //添加静态资源至过滤链
        webSecurity.ignoring().antMatchers("/webjars/**", "/images/**", "/static/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and().csrf().ignoringAntMatchers("/api/**", "/admin-api/**", "/console-api/**")
                .and()
                .authorizeRequests()
                .antMatchers("/login", "/register", "/swagger**/**", "/v2/api-docs").permitAll()
                .antMatchers("/health", "/info", "/loggers", "/heapdump", "/metrics", "/hystrix.stream/**", "/mappings").permitAll()
                .antMatchers("/trace", "/logfile", "/env", "/refresh", "/dump", "/auditevents", "/flyway","/liquibase").permitAll()
                .antMatchers("/jolokia").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/console/**").hasRole("DEVELOPER")
                //todo add permission check
                .antMatchers("/monitoring/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successHandler(new SuccessHandler())
                .and()
                //开启记住密码
                .rememberMe()
                .tokenRepository(tokenRepository())
                .tokenValiditySeconds(604800)
                .and()
                .logout();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public InMemoryTokenRepositoryImpl tokenRepository() {
        InMemoryTokenRepositoryImpl repository = new InMemoryTokenRepositoryImpl();
        return repository;
    }

}