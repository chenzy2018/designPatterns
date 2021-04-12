package com.designPatterns.a04Facade;

import com.designPatterns.Circle;
import com.designPatterns.Rectangle;
import com.designPatterns.Shape;
import com.designPatterns.Square;

/**
 * 外观模式
 */
public class ShapeMaker {
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
