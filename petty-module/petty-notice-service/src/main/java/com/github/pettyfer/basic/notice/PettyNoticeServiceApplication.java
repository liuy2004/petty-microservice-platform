package com.github.pettyfer.basic.notice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 消息提示/发送中心
 * @author Petty
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PettyNoticeServiceApplication {

	public static void main(String[] args) {
		System.out.println("The service to start.");
		SpringApplication.run(PettyNoticeServiceApplication.class, args);
		System.out.println("The service has started.");
	}
}
