package com.github.pettyfer.basic.oauth.config;

import com.github.pettyfer.basic.common.config.FilterUrlsPropertiesConfig;
import com.github.pettyfer.basic.oauth.component.mobile.MobileSecurityConfigurer;
import com.github.pettyfer.basic.oauth.handler.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

/**
 * @author Petty
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final FilterUrlsPropertiesConfig filterUrlsPropertiesConfig;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private MobileSecurityConfigurer mobileSecurityConfigurer;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, FilterUrlsPropertiesConfig filterUrlsPropertiesConfig) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.filterUrlsPropertiesConfig = filterUrlsPropertiesConfig;
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
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .formLogin().loginPage("/login").successHandler(new SuccessHandler())
                .and()
                //开启记住密码
                .rememberMe()
                .tokenRepository(tokenRepository())
                .tokenValiditySeconds(604800)
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/console/**").hasRole("DEVELOPER");
        for (String url : filterUrlsPropertiesConfig.getAnon()) {
            registry.antMatchers(url).permitAll();
        }
        registry.anyRequest().authenticated().and().logout();
        http.apply(mobileSecurityConfigurer);
    }

    @Bean
    public InMemoryTokenRepositoryImpl tokenRepository() {
        InMemoryTokenRepositoryImpl repository = new InMemoryTokenRepositoryImpl();
        return repository;
    }

}