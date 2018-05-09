package com.github.pettyfer.basic.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Petty
 */
@Slf4j
@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class PettyConfigServiceApplication {

	public static void main(String[] args) {
		log.info("The service to start.");
		SpringApplication.run(PettyConfigServiceApplication.class, args);
		log.info("The service has started.");
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
