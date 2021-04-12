package com.designPatterns.a06Decorator;


public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Rectangle();
        //ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
