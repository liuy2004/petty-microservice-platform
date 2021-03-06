package com.github.pettyfer.basic.common.annotation;

import java.lang.annotation.*;

/**
 * 是否通过Token解析用户上下文
 *
 * @author Petty
 * @since 2018-04-01
 * 注解使用请见{@link com.github.pettyfer.basic.common.aop.UserContextAop}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface UserContext {
}
