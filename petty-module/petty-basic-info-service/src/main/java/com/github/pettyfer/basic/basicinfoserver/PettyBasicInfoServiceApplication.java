package com.github.pettyfer.basic.basicinfoserver;

import com.github.pettyfer.basic.common.annotation.CommonApi;
import com.github.pettyfer.basic.common.annotation.PettyConfigurer;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@PettyConfigurer
@CommonApi
public class PettyBasicInfoServiceApplication {

	public static void main(String[] args) {
		log.info("The service to start.");
		SpringApplication.run(PettyBasicInfoServiceApplication.class, args);
		log.info("The service has started.");
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
