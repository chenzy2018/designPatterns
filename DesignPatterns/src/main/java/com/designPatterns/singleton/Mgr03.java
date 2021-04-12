package com.designPatterns.singleton;

/**
 * 懒汉式
 *
 * 用到的时候再加载
 */
public class Mgr03 {

    private volatile static Mgr03 instance;

    private Mgr03() {}

    //DCL(double check lock)
    public static Mgr03 getInstance(){
        if(instance == null){
            synchronized (instance){
                if(instance == null) instance = new Mgr03();
            }
        }
        return instance;
    }

    public void m(){
        System.out.println("m");
    }
}
