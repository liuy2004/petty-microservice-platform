package com.github.pettyfer.basic.oauth;

import com.github.pettyfer.basic.common.annotation.PettyConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

/**
 * 认证服务&资源服务
 * @author Petty
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@EnableFeignClients({"com.github.pettyfer.basic.common.feign","com.github.pettyfer.basic.oauth.feign"})
@EnableHystrix
@PettyConfigurer
public class PettyOAuth2ServiceApplication {

	public static void main(String[] args) {
		System.out.println("The service to start.");
		SpringApplication.run(PettyOAuth2ServiceApplication.class, args);
		System.out.println("The service has started.");
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
