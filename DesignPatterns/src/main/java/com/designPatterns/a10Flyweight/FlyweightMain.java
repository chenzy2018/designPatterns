package com.designPatterns.a10Flyweight;

import com.designPatterns.Circle;

/**
 * 享元模式
 */
public class FlyweightMain {

    private static final String colors[] ={ "Red", "Green", "Blue", "White", "Black" };

    public static void main(String[] args) {

        for(int i=0; i < 20; ++i) {
            Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandom());
            circle.setY(getRandom());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }

    private static int getRandom() {
        return (int)(Math.random()*100);
    }
}