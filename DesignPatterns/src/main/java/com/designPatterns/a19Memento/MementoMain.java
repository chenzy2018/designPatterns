package com.designPatterns.a19Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式
 */
public class MementoMain {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}

//备忘录类，用于记录Originator的状态
class Memento{
    private String stute;

    public Memento(String stute) {
        this.stute = stute;
    }

    public String getStute() {
        return stute;
    }
}

//鼻祖类
class Originator{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getStute();
    }
}

//管理人类 --> 管理备忘录的
class CareTaker {
    List<Memento> list = new ArrayList<>();

    public void add(Memento memento){
        list.add(memento);
    }

    public Memento get(int index){
        return list.get(index);
    }
}
