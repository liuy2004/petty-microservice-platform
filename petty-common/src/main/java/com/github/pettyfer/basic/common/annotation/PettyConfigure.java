package com.github.pettyfer.basic.common.annotation;

import com.github.pettyfer.basic.common.config.AutoConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(AutoConfigure.class)
@Documented
@Inherited
public @interface PettyConfigure {
}
