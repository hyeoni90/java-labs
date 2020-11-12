package com.hyeonah.studyjava.java8to11.annotation;

import java.lang.annotation.*;

/**
 * Created by hyeonahlee on 2020-11-12.
 *
 * 어노테이션 반복하게 사용할 수 있도록 한다.
 * Repeatable
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    String value();
}

