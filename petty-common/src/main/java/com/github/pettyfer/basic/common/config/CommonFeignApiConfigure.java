package com.github.pettyfer.basic.common.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients({"com.github.pettyfer.basic.common.feign"})
public class CommonFeignApiConfigure {
}
