package com.hyeonah.studyjava.java8to11.annotation;

import java.util.Arrays;

/**
 * Created by hyeonahlee on 2020-11-12.
 */
@Chicken("마늘간장")
@Chicken("양념")
public class App2 {

    public static void main(String[] args) {
        ChickenContainer chickenContainer = App2.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value())
                .forEach(c -> {
                    System.out.println(c.value());
                });
    }
}
