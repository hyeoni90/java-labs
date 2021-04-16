package com.hyeonah.javalabs.designpattern.strategypattern.move;

/**
 * Created by hyeoni90 on 2021-03-03
 */
public class Walk implements MovingStrategy {
    @Override
    public void move() {
        System.out.println("걸어간다.");
    }
}
