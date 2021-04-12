package com.designPatterns.a03factory.abstractFactory;

import com.designPatterns.a03factory.bean.Food;
import com.designPatterns.a03factory.bean.Vehicle;
import com.designPatterns.a03factory.bean.Weapon;

/**
 * 抽象工厂的具体实现
 *
 * 这样就可以用于生产Modern的一系列产品
 */
public class ModernFactory extends AbstractVehicleFactory{
    @Override
    Food createFoot() {
        return null;//具体写个类继承Food，然后返回该类的实例，下面方法同理
    }

    @Override
    Weapon createWeapon() {
        return null;
    }

    @Override
    Vehicle createVehicle() {
        return null;
    }
}
