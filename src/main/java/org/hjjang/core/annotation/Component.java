package org.hjjang.core.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Bean
public @interface Component {
    String value() default "";
}
