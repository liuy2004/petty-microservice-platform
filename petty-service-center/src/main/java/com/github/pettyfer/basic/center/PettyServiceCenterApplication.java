package com.github.pettyfer.basic.center;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ${DESCRIPTION}
 *
 * @author Pettyfer Alex
 * @create 2017年12月8日
 */
@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class PettyServiceCenterApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		log.info("The service to start.");
		SpringApplication.run(PettyServiceCenterApplication.class, args);
		log.info("The service has started.");
	}
}

