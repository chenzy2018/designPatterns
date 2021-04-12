package com.designPatterns.a06Decorator;

/**
 * 图形颜色装饰器具体实现
 */
public class RedShapeDecorator extends ShapeDecorator{

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
