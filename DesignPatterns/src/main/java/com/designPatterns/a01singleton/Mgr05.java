package com.designPatterns.a01singleton;

/**
 * 枚举方式
 *
 * 完美方法之一，不仅可以解决线程同步，还可以防止反序列化
 *
 * 前面所有方式都可以通过反序列化(反射)方式重新创建实例
 * enum可以防止反序列化(反射)的原因：没有构造方法
 */
public enum Mgr05 {

    INSTANCE;

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr05 instance = Mgr05.INSTANCE;
    }
}
