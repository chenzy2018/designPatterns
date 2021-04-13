package com.designPatterns.a10Flyweight;

import com.designPatterns.Circle;
import com.designPatterns.Shape;

import java.util.HashMap;

//工厂，生成基于给定信息的实体类的对象
public class ShapeFactory {
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
