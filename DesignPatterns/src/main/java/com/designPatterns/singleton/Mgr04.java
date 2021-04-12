package com.designPatterns.singleton;

/**
 * 静态内部类
 *
 * 完美写法之一，JVM保证单例
 *
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Mgr04 {

    private Mgr04(){}

    private static class Mgr04Holder{//类只会加载一次，因此只会有一个实例
        private final static Mgr04 instance = new Mgr04();
    }

    public static Mgr04 getInstance(){
        return Mgr04Holder.instance;
    }

    public void m(){
        System.out.println("m");
    }
}
