package com.designPatterns.a11Proxy;

/**
 * 静态代理：事先写好代理代码，然后编译运行
 *
 * 需要事先知道类的方法，因此有局限，不方便扩展
 */
public class StaticProxyMain {

    public static void main(String[] args) {
        //由于 代理类 也是实现Moveable，所以可以 代理 代理类 --> 精髓
        new AddTimeProxy(new AddLogProxy(new Tank())).move();//类似decorator(装饰器模式)
    }
}

//移动接口
interface Moveable{
    void move();
}

//需要给Tank类(包括其他实现类Moveable接口的类)加执行时间以及日志记录
class Tank implements Moveable{
    @Override
    public void move() {
        System.out.println("tank is moving...");
    }
}

//执行时间代理类
class AddTimeProxy implements Moveable{

    Moveable m;

    public AddTimeProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.nanoTime();
        m.move();
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}

//日志记录代理类
class AddLogProxy implements Moveable{

    Moveable m;

    public AddLogProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("start moving..");
        m.move();
        System.out.println("end moving..");

    }
}