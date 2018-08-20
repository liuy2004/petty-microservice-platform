package com.github.pettyfer.basic.common.configurer;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置公共FeignApi
 *
 * @author Petty
 */
@Configuration
@EnableFeignClients({"com.github.pettyfer.basic.common.feign"})
@ComponentScan(basePackages = {"com.github.pettyfer.basic.common.feign.fallback"})
public class CommonFeignApiConfigurer {
}
