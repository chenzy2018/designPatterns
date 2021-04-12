package com.designPatterns.a03factory.abstractFactory;

import com.designPatterns.a03factory.bean.Food;
import com.designPatterns.a03factory.bean.Vehicle;
import com.designPatterns.a03factory.bean.Weapon;

/**
 * 抽象工厂
 *
 * 用于生产产品族
 */
public abstract class AbstractVehicleFactory {

    abstract Food createFoot();

    abstract Weapon createWeapon();

    abstract Vehicle createVehicle();
}
