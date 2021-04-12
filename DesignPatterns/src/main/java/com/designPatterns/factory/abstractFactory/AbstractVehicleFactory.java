package com.designPatterns.factory.abstractFactory;

import com.designPatterns.factory.bean.Food;
import com.designPatterns.factory.bean.Vehicle;
import com.designPatterns.factory.bean.Weapon;

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
