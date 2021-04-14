package com.designPatterns.a10Flyweight;

import com.designPatterns.Circle;
import com.designPatterns.Shape;

import java.util.HashMap;

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

//工厂，生成基于给定信息的实体类的对象
class ShapeFactory {
    //维护一个Shape池
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
