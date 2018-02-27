package com.github.pettyfer.basic.gateway.ratelimit;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * @author Petty
 * @date 2017年12月8日
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RateLimitAutoConfiguration.class)
@Documented
@Inherited
public @interface EnablePettyGatewayRatelimit {
}
