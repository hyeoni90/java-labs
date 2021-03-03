package com.hyeonah.javalabs.designpattern.strategy.move;

/**
 * Created by hyeoni90 on 2021-03-03
 */
public class Fly implements MovingStrategy {
    @Override
    public void move() {
        System.out.println("날아간다.");
    }
}
