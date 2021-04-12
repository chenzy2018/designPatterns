package com.designPatterns.a03factory.simpleFactory;

import com.designPatterns.a03factory.bean.Car;
import com.designPatterns.a03factory.bean.Moveable;

/**
 * 简单工厂
 *
 * 可扩展性不好
 */
public class SimpleVehicleFactory {

    public Moveable create(){
        //PerProcess，like right、log
        return new Car();
        //return new Plane();
    }
}
