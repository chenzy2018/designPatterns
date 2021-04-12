package com.designPatterns.factory.simpleFactory;

import com.designPatterns.factory.bean.Car;
import com.designPatterns.factory.bean.Moveable;
import com.designPatterns.factory.bean.Plane;

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
