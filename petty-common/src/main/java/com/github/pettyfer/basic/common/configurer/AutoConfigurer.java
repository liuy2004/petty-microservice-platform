package com.github.pettyfer.basic.common.configurer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Petty
 */
@Configuration
@ComponentScan(basePackages = {
        "com.github.pettyfer.basic.common.config",
        "com.github.pettyfer.basic.common.handler",
        "com.github.pettyfer.basic.common.interceptor",
        "com.github.pettyfer.basic.common.utils",
        "com.github.pettyfer.basic.common.aop"
})
public class AutoConfigurer {
}
