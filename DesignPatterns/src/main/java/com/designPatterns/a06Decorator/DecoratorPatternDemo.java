package com.designPatterns.a06Decorator;


import com.designPatterns.Rectangle;
import com.designPatterns.Shape;

/**
 * 装饰器模式
 */
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

/**
 * 图形颜色装饰器
 */
abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}

/**
 * 图形颜色装饰器具体实现
 */
class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setColor(decoratedShape);
    }

    void setColor(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
