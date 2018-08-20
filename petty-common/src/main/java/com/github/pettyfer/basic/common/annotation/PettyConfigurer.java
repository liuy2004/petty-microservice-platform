package com.github.pettyfer.basic.common.annotation;

import com.github.pettyfer.basic.common.configurer.AutoConfigurer;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(AutoConfigurer.class)
@Documented
@Inherited
public @interface PettyConfigurer {
}
