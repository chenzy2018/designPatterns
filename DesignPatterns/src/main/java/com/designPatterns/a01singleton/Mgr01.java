package com.designPatterns.a01singleton;

/**
 * 饿汉式
 *
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单使用，推荐使用
 *
 * 唯一缺点：不管用到与否，类加载时都会完成实例化(不需要用的，可以不装载)
 */
public class Mgr01 {

    private static final Mgr01 instance = new Mgr01();

    //私有化构造方法，关键
    private Mgr01(){}

    public static Mgr01 getInstance(){
        return instance;
    }

    public void m(){
        System.out.println("m");
    }
}
