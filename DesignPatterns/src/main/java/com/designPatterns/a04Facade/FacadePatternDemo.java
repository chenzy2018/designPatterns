package com.designPatterns.a04Facade;

/**
 * 只需要直到ShapeMaker类和对应API，对具体内部的Rectangle等类不需要关注
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
