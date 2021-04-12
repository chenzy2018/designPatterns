package com.designPatterns;

import com.designPatterns.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("shape: Rectangle");
    }
}
