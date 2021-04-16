package com.hyeonah.javalabs.designpattern.strategypattern;

import com.hyeonah.javalabs.designpattern.strategypattern.move.MovingStrategy;

/**
 * Created by hyeoni90 on 2021-03-03
 */
public class Animal {
    private final String name;

    private MovingStrategy movingStrategy;

    public Animal(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move() {
        movingStrategy.move();
    }

    public void setMovingStrategy(final MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }
}
