package com.designPatterns.factory;

import com.designPatterns.factory.bean.Car;
import com.designPatterns.factory.bean.Moveable;
import com.designPatterns.factory.bean.Plane;
import com.designPatterns.factory.simpleFactory.SimpleVehicleFactory;

/**
 * 工厂模式Main
 */
public class FactoryMain {
    public static void main(String[] args) {

        //每多一种交通工具都需要这样new，然后调用方法
        Car car = new Car();
        car.go();
        Plane plane = new Plane();
        plane.go();

        //抽取Moveable接口
        //相比上面的好些
        Moveable mv = new Plane();
        Moveable mv1 = new Car();//需要什么就new什么，也可以使用配置文件的方式指定，就不用动具体代码
        mv.go();

        //简单工厂
        Moveable mva = new SimpleVehicleFactory().create();
        mva.go();

        //抽象工厂
    }
}
