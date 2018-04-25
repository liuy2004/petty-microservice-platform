package com.github.pettyfer.basic.basicinfoserver;

import com.github.pettyfer.basic.common.annotation.CommonApi;
import com.github.pettyfer.basic.common.annotation.PettyConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Petty
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@PettyConfigurer
@CommonApi
public class PettyBasicInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PettyBasicInfoServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
