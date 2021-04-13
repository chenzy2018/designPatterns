package com.designPatterns.a08Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 *
 * 需求：实现孩子哭了，爸爸喂奶，妈妈睡觉，狗吠
 */
public class ObserverMain {

    public static void main(String[] args) {
        Child child = Child.getInstance();
        Event<Child> event = new ChildEvent<Child>("孩子哭",1,child);
        child.event = event;
        child.wakeUp();
    }
}

class Child{
    String name;
    Event event;
    boolean cry;

    List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Father());
        observers.add(new Mother());
        observers.add(new Dog());
        observers.add((e)->{
            System.out.println("Cat is running");
            System.out.println(e.getRource());
        });//钩子函数，传递的是一个函数，事件触发就会执行
    }

    //饿汉单例
    private static final Child Instance = new Child();
    private Child(){}
    public static Child getInstance(){
        return Instance;
    }

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;

        for(Observer o : observers){
            o.doIt(event);
        }
    }
}

//事件是用来隔离(解耦)观察者和被观察者，观察者也可以根据事件的不同做不同的反应
abstract class Event<T>{
    abstract T getRource();//提供这个方法是为了观察者可以获取事件源，根据不同的事件源作不同的反应
}

class ChildEvent<T> extends Event<T>{
    String name;
    int type;
    T source;//来源

    public ChildEvent(String name, int type, T source) {
        this.name = name;
        this.type = type;
        this.source = source;
    }

    @Override
    T getRource() {
        return source;
    }
}

//观察者接口
interface Observer{
    void doIt(Event e);
}

class Father implements Observer{

    public void feed(Event e){
        System.out.println("Father is feeding");
    }

    @Override
    public void doIt(Event e) {
        feed(e);//可以增加对不同事件的不同处理，考虑策略模式
        System.out.println(e.getRource());
    }
}

class Mother implements Observer{

    public void sleep(Event e){
        System.out.println("Mother is sleeping");
    }

    @Override
    public void doIt(Event e) {
        sleep(e);//可以增加对不同事件的不同处理，考虑策略模式
        System.out.println(e.getRource());
    }
}

class Dog implements Observer{

    public void bark(Event e){
        System.out.println("Dog is barking");
    }

    @Override
    public void doIt(Event e) {
        bark(e);//可以增加对不同事件的不同处理，考虑策略模式
        System.out.println(e.getRource());
    }
}