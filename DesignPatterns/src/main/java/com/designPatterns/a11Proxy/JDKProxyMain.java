package com.designPatterns.a11Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理：基于反射，面向接口(代理类必须实现一个或多个接口)
 *  底层使用的ASM(直接操作二进制文件的技术 --> java动态语言)
 */
public class JDKProxyMain {

    static class Tank implements Moveable{

        public void trun() {
            System.out.println("Tank is truning..");
        }

        @Override
        public void move() {
            System.out.println("Tank is moving..");
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        //设置此属性为true之后，jdk会将生成代理类保存下来，在根目录下的com包中查看
        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");

        //相当于生成了静态代理里的AddLogProxy类
        /**
         * 第一个参数：指定动态代理生成的类用什么类加载器加载到内存
         * 第二个参数：指定动态代理生成的类需要实现哪些接口
         * 第三个参数：传入实现了InvocationHandler的类的对象 --> 匿名内部类写法即可
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Moveable.class},
                new InvocationHandler() {
                    @Override
                    //proxy代表的是m，因为生成的代理类中传的是this，一般情况下该参数用不上，除非需要使用到proxy的其他方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("mothed "+ method.getName() + " start");
                        Object invoke = method.invoke(tank, args);//相当于tank.move()
                        System.out.println("mothed "+ method.getName() + " end");
                        return invoke;
                    }
                });

        m.move();
    }
}

