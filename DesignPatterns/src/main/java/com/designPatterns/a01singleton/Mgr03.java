package com.designPatterns.a01singleton;

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
            synchronized (Mgr03.class){
                if(instance == null) instance = new Mgr03();
            }
        }
        return instance;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        System.out.println(Mgr03.getInstance());
        System.out.println(Mgr03.getInstance());
    }
}
