package com.github.pettyfer.basic.common.annotation;

import java.lang.annotation.*;

/**
 * 配置该注解即开启用户鉴权，效验Token有效性并获取用户信息
 * @author Petty
 * @since 2018-04-01
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface UserAuth {
    /**
     * 是否需要用户基础信息
     * @return boolean
     */
    boolean isUserDetails() default true;
}
