package com.github.pettyfer.basic.notice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 消息提示/发送中心
 * @author Petty
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class PettyNoticeServiceApplication {

	public static void main(String[] args) {
		log.info("The service to start.");
		SpringApplication.run(PettyNoticeServiceApplication.class, args);
		log.info("The service has started.");
	}
}
