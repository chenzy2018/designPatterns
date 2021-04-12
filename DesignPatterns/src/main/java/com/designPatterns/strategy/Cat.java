package com.designPatterns.strategy;

public class Cat {

    int wieght;
    int height;

    public Cat(int wieght, int height) {
        this.wieght = wieght;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "wieght=" + wieght +
                ", height=" + height +
                '}';
    }
}
