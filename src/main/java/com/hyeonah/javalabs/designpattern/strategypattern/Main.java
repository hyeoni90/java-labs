package com.hyeonah.javalabs.designpattern.strategypattern;

import com.hyeonah.javalabs.designpattern.strategypattern.move.Fly;
import com.hyeonah.javalabs.designpattern.strategypattern.move.Swim;
import com.hyeonah.javalabs.designpattern.strategypattern.move.Walk;

/**
 * Created by hyeoni90 on 2021-03-03
 */
public class Main {

    public static void main(final String[] args) {
//        final Cat cat = new Cat("고양이");
//        final Dog dog = new Dog("강아지");
//        final Fish fish = new Fish("물고기");
//        final Bird bird = new Bird("새");
//
//        cat.move();
//        dog.move();
//        fish.move();
//        bird.move();

        // 두개의 차이가 뭘까?
//        final Animal cat = new Cat("고양이");
        final Cat cat = new Cat("고양이");
        cat.cry();

        final Dog dog = new Dog("강아지");
        final Fish fish = new Fish("물고기");
        final Bird bird = new Bird("새");

        cat.setMovingStrategy(new Fly());
        System.out.print(cat.getName() + " ");
        cat.move();

        dog.setMovingStrategy(new Swim());
        System.out.print(dog.getName() + " ");
        dog.move();
        dog.setMovingStrategy(new Walk());
        dog.move();

        fish.setMovingStrategy(new Fly());
        System.out.print(fish.getName() + " ");
        fish.move();

        bird.setMovingStrategy(new Walk());
        System.out.print(bird.getName() + " ");
        bird.move();
    }
}
