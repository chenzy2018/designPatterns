package com.designPatterns.a06Decorator;

import com.designPatterns.Shape;

/**
 * 图形颜色装饰器
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
