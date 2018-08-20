package com.github.pettyfer.basic.common.annotation;

import com.github.pettyfer.basic.common.configurer.CommonFeignApiConfigurer;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(CommonFeignApiConfigurer.class)
@Documented
@Inherited
public @interface CommonApi {
}
