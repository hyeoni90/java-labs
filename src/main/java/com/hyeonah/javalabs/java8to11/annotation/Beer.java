package com.hyeonah.javalabs.java8to11.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hyeonahlee on 2020-11-12.
 *
 * 어노테이션 2가지 변화,
 * annotation 타입 선언부에도 사용할 수 있게 됨. 타입 선언 부 (제너릭, 변수, 매개변수, 예외 타입)
 * annotation을 중복해서 사용할 수 있게 됨.
 *
 * Retention 전략. 정보를 언제까지 유지할 것인가!
 * Target: 사용할 곳 아래 2가지 추가됨
 *  - ElementType.TYPE_PARAMETER : 타입 변수에만 사용
 *  - ElementType.TYPE_USE : 타입 변수 포함 타입 선언 부 사용
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface Beer {
}
