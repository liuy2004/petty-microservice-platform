package com.github.pettyfer.demo;

import com.github.pettyfer.basic.common.annotation.PettyConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author Petty
 */
@EnableOAuth2Sso
@SpringBootApplication
@PettyConfigure
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
