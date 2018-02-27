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

package com.github.pettyfer.basic.gateway.ratelimit.config;

import com.github.pettyfer.basic.gateway.ratelimit.config.properties.RateLimitProperties;

/**
 * @author Marcos Barbero
 * @author Liel Chayoun
 */
public interface RateLimiter {

    /**
     * @param policy      Template for which rates should be created in case there's no rate limit associated with the
     *                    key
     * @param key         Unique key that identifies a request
     * @param requestTime The total time it took to handle the request
     * @return a view of a user's rate request limit
     */

    /**
     * 通过该方法判断请求，并增加请求数量
     * @param policy
     * @param key
     * @param requestTime
     * @return
     */
    Rate consume(RateLimitProperties.Policy policy, String key, Long requestTime);
}
