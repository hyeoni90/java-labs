package com.hyeonah.studyjava.java8to11.functional;

/**
 * Created by hyeonahlee on 2020-11-12.
 */
public class Foo {

    public static void main(String[] args) {
        // lambda expression
        RunSomething runSomething = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };

        runSomething.doIt();
    }
}
