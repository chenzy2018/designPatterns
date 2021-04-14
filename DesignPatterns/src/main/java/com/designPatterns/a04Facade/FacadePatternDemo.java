package com.designPatterns.a04Facade;

import com.designPatterns.Circle;
import com.designPatterns.Rectangle;
import com.designPatterns.Shape;
import com.designPatterns.Square;

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

class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}

