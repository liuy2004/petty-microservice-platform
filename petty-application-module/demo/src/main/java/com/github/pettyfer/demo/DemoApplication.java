package com.github.pettyfer.demo;

import com.github.pettyfer.basic.common.annotation.PettyConfigurer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author Petty
 */
@Slf4j
@EnableOAuth2Sso
@SpringBootApplication
@PettyConfigurer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoApplication {

    public static void main(String[] args) {
        log.info("The service to start.");
        SpringApplication.run(DemoApplication.class, args);
        log.info("The service has started.");
    }
}
