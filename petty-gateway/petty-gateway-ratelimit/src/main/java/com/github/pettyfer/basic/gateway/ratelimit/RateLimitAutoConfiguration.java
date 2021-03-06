/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.pettyfer.basic.gateway.ratelimit;

import com.ecwid.consul.v1.ConsulClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pettyfer.basic.gateway.ratelimit.config.DefaultRateLimitKeyGenerator;
import com.github.pettyfer.basic.gateway.ratelimit.config.RateLimitKeyGenerator;
import com.github.pettyfer.basic.gateway.ratelimit.config.RateLimiter;
import com.github.pettyfer.basic.gateway.ratelimit.config.properties.RateLimitProperties;
import com.github.pettyfer.basic.gateway.ratelimit.config.repository.ConsulRateLimiter;
import com.github.pettyfer.basic.gateway.ratelimit.config.repository.InMemoryRateLimiter;
import com.github.pettyfer.basic.gateway.ratelimit.config.repository.RedisRateLimiter;
import com.github.pettyfer.basic.gateway.ratelimit.config.repository.springdata.JpaRateLimiter;
import com.github.pettyfer.basic.gateway.ratelimit.config.repository.springdata.RateLimiterRepository;
import com.github.pettyfer.basic.gateway.ratelimit.filters.RateLimitPostFilter;
import com.github.pettyfer.basic.gateway.ratelimit.filters.RateLimitPreFilter;
import com.netflix.zuul.ZuulFilter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.consul.ConditionalOnConsulEnabled;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.util.UrlPathHelper;

import static com.github.pettyfer.basic.gateway.ratelimit.config.properties.RateLimitProperties.PREFIX;

/**
 * @author Marcos Barbero
 */
@Configuration
@EnableConfigurationProperties(RateLimitProperties.class)
@ConditionalOnProperty(prefix = PREFIX, name = "enabled", havingValue = "true")
public class RateLimitAutoConfiguration {

    private final UrlPathHelper urlPathHelper = new UrlPathHelper();

    /**
     * 创建一个filterType为Pre的过滤器 注：filterType为请求响应前触发
     *
     * @param rateLimiter
     * @param rateLimitProperties
     * @param routeLocator
     * @param rateLimitKeyGenerator
     * @return
     */
    @Bean
    public ZuulFilter rateLimiterPreFilter(final RateLimiter rateLimiter,
                                           final RateLimitProperties rateLimitProperties,
                                           final RouteLocator routeLocator,
                                           final RateLimitKeyGenerator rateLimitKeyGenerator) {
        return new RateLimitPreFilter(rateLimitProperties, routeLocator, urlPathHelper, rateLimiter,
                rateLimitKeyGenerator);
    }

    /**
     * 创建一个filterType为POST的过滤器 注：filterType为请求响应前触发
     *
     * @param rateLimiter
     * @param rateLimitProperties
     * @param routeLocator
     * @param rateLimitKeyGenerator
     * @return
     */
    @Bean
    public ZuulFilter rateLimiterPostFilter(final RateLimiter rateLimiter,
                                            final RateLimitProperties rateLimitProperties,
                                            final RouteLocator routeLocator,
                                            final RateLimitKeyGenerator rateLimitKeyGenerator) {
        return new RateLimitPostFilter(rateLimitProperties, routeLocator, urlPathHelper, rateLimiter,
                rateLimitKeyGenerator);
    }

    /**
     * 当前上下文中不存在RateLimitKeyGenerator对象时实例化该对象
     *
     * @param properties
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(RateLimitKeyGenerator.class)
    public RateLimitKeyGenerator ratelimitKeyGenerator(final RateLimitProperties properties) {
        return new DefaultRateLimitKeyGenerator(properties);
    }

    /**
     * @ConditionalOnClass 某个RedisTemplate位于类路径上，实例化Bean
     * @ConditionalOnMissingBean 当前上下文中不存在RateLimiter对象时，实例化Bean
     * @ConditionalOnProperty 当前上下文是否存在制定参数，存在即执行代码
     */
    @ConditionalOnClass(RedisTemplate.class)
    @ConditionalOnMissingBean(RateLimiter.class)
    @ConditionalOnProperty(prefix = PREFIX, name = "repository", havingValue = "REDIS")
    public static class RedisConfiguration {

        @Bean("rateLimiterRedisTemplate")
        public StringRedisTemplate redisTemplate(final RedisConnectionFactory connectionFactory) {
            return new StringRedisTemplate(connectionFactory);
        }

        @Bean
        public RateLimiter redisRateLimiter(@Qualifier("rateLimiterRedisTemplate") final RedisTemplate redisTemplate) {
            return new RedisRateLimiter(redisTemplate);
        }
    }

    @ConditionalOnConsulEnabled
    @ConditionalOnMissingBean(RateLimiter.class)
    @ConditionalOnProperty(prefix = PREFIX, name = "repository", havingValue = "CONSUL")
    public static class ConsulConfiguration {

        @Bean
        public RateLimiter consultRateLimiter(final ConsulClient consulClient, final ObjectMapper objectMapper) {
            return new ConsulRateLimiter(consulClient, objectMapper);
        }

    }

    @EntityScan
    @EnableJpaRepositories
    @ConditionalOnMissingBean(RateLimiter.class)
    @ConditionalOnProperty(prefix = PREFIX, name = "repository", havingValue = "JPA")
    public static class SpringDataConfiguration {

        @Bean
        public RateLimiter springDataRateLimiter(final RateLimiterRepository rateLimiterRepository) {
            return new JpaRateLimiter(rateLimiterRepository);
        }

    }

    @ConditionalOnMissingBean(RateLimiter.class)
    @ConditionalOnProperty(prefix = PREFIX, name = "repository", havingValue = "IN_MEMORY", matchIfMissing = true)
    public static class InMemoryConfiguration {

        @Bean
        public RateLimiter inMemoryRateLimiter() {
            return new InMemoryRateLimiter();
        }
    }

}
