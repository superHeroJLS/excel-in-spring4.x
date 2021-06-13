package com.smart.inheritedtest;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface InheritedParent {
    String value() default "";
}
