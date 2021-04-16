package com.hyeonah.javalabs.designpattern.strategypattern;

/**
 * Created by hyeoni90 on 2021-03-03
 */
public class Cat extends Animal {

    public Cat(final String name) {
        super(name);
    }

    public void cry() {
        System.out.println("운다");
    }
}
