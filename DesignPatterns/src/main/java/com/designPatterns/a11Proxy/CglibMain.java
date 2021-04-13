package com.designPatterns.a11Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib动态代理：代理类是目标类的子类，因此不能代理final修饰的类
 *  底层使用的ASM(直接操作二进制文件的技术 --> java动态语言)
 */
public class CglibMain {

    static class Tank{

        public void trun() {
            System.out.println("Tank is truning..");
        }

        public void move() {
            System.out.println("Tank is moving..");
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);//设置代理类的父类为Tank
        enhancer.setCallback(new TimeMethodInterceptor());//设置回调方法
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor{
    @Override

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass().getSuperclass().getName());//o是代理类，是目标类的子类
        System.out.println("before move");
        Object invoke = methodProxy.invokeSuper(o, objects);//如果直接使用o作为参数传递，就用invokeSuper，如果用目标类的对象，就用invokle
        System.out.println("after move");
        return invoke;
    }
}
