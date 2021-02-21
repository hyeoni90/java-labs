package com.hyeonah.javalabs.java8to11.functional;

/**
 * Created by hyeonahlee on 2020-11-12.
 */
public class Foo {

    public static void main(final String[] args) {
        // lambda expression
        final RunSomething runSomething = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };

        runSomething.doIt();
    }
}
