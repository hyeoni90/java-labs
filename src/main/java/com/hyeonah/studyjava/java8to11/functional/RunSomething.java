package com.hyeonah.studyjava.java8to11.functional;

/**
 * Created by hyeonahlee on 2020-11-12.
 *
 * 추상 메서드 1개 > 함수형 인터페이스
 * static, default 메서드 정의 할 수 있음
 */
@FunctionalInterface
public interface RunSomething {

    void doIt();

    static void printName() {
        System.out.println("Hyeonah");
    }

    default void printAge() {
        System.out.println("30");
    }
}
