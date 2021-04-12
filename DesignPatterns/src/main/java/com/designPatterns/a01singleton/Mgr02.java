package com.designPatterns.a01singleton;

/**
 * 饿汉式
 *
 * 和Mgr01一样，只不过初始化使用静态代码块
 */
public class Mgr02 {

    private static final Mgr02 instance;

    static {
        instance = new Mgr02();
    }

    //私有化构造方法，关键
    private Mgr02(){}

    public static Mgr02 getInstance(){
        return instance;
    }

    public void m(){
        System.out.println("m");
    }
}
