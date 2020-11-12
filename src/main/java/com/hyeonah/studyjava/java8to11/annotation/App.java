package com.hyeonah.studyjava.java8to11.annotation;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hyeonahlee on 2020-11-12.
 */
@Beer
public class App {

    public static void main(@Beer String[] args) throws @Beer RuntimeException {
        List<@Beer String> names = Arrays.asList("hyeonah");
    }

    // ElementType.TYPE_PARAMETER
//    static class FeelsLikeChicken<@Beer T> {
//
//        public static <@Beer C> void print (C c) {
//
//        }
//    }

    static class FeelsLikeChicken<@Beer T> {

        public static <@Beer C> void print (@Beer C c) {
            System.out.println(c);
        }
    }
}
