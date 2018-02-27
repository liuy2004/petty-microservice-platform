package com.github.pettyfer.basic.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ${DESCRIPTION}
 *
 * @author Pettyfer Alex
 * @create 2017年12月8日
 */

@EnableEurekaServer
@SpringBootApplication
public class PettyServiceCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PettyServiceCenterApplication.class, args);
	}
}

