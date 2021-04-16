package com.designPatterns.a21State;

/**
 * 状态模式：当方法(动作)在不同情况下会有不同的表现得时候就可以使用
 *  可以消除if...else...(switch...case...)
 *
 *  扩展动作非常好用(如果这种情形比较多建议使用)，但是扩展方法就非常复杂(如果这种情形比较多不建议使用)
 */
public class StateMain {
    public static void main(String[] args) {
        MM mm = new MM();
        mm.state = new HappyAction();
        mm.cry();
        mm.smile();
        mm.talk();
    }
}

class MM{
    String name;
    DoAction state;

    public void smile() {
        state.smile();
    }

    public void cry() {
        state.cry();
    }

    public void talk() {
        state.talk();
    }
}

//定义一系列动作
interface DoAction{
    void smile();
    void cry();
    void talk();
}

//happy状态
class HappyAction implements DoAction{

    @Override
    public void smile() {
        System.out.println("happy smile");
    }

    @Override
    public void cry() {
        System.out.println("happy cry");
    }

    @Override
    public void talk() {
        System.out.println("happy talk");
    }
}

//sad状态
class SadAction implements DoAction{

    @Override
    public void smile() {
        System.out.println("sad smile");
    }

    @Override
    public void cry() {
        System.out.println("sad cry");
    }

    @Override
    public void talk() {
        System.out.println("sad talk");
    }
}

//继续扩展

/**
 * 这是没用状态模式的方式，用于对比
 */
class GG{
    String name;
    //表示状态
    private enum GGstate{
        happy,
        sad
    }
    GGstate state;

    //如果增加状态，就每个方法都要加
    public void smile(){
        switch (state){
            case happy:
                System.out.println("happe smile");
                break;
            case sad:
                System.out.println("happy sad");
                break;
        }
    }

    public void cry(){
        //switch...case...
    }

    public void talk(){
        //switch...case...
    }
}

