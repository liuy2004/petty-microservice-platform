package com.github.pettyfer.basic.basicinfoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@ComponentScan(basePackages = {"com.github.pettyfer.basic"})
public class PettyBasicInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PettyBasicInfoServiceApplication.class, args);
	}
}
