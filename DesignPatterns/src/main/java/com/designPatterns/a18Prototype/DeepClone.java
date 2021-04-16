package com.designPatterns.a18Prototype;

/**
 * 深拷贝：不仅复制对象，对象内部的引用属性也拷贝
 *
 * 关注一个问题：String需要做拷贝吗 --> String也是一个引用对象，但不需要做拷贝，因为在字符串常量池中只会存在一份
 *  --> 如果是用new String()传递或者是StringBuilder传递，是需要考虑拷贝的
 */
public class DeepClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Bridge b1 = new Bridge().baseInfo(18,"jack").locationInfo(new BridgeLocation("sd",38)).build();

        Bridge b2 = (Bridge) b1.clone();

        //深拷贝下引用属性会拷贝，因此不一样
        System.out.println(b1.location == b2.location);
        b1.location.street = "de";
        System.out.println(b2.location.street);//不受b1的改动影响
    }
}

//Cloneable是一个标记接口(空接口，没有定义一个方法)
class Bridge implements Cloneable{
    int age;
    String name;

    BridgeLocation location;

    //建造者模式
    public Bridge baseInfo(int age, String name){
        this.age = age;
        this.name = name;
        return this;
    }
    public Bridge locationInfo(BridgeLocation location){
        this.location = location;
        return this;
    }
    public Bridge build(){
        return this;
    }

    //拷贝函数，必须要实现Cloneable，才能调用，不然运行时会报错
    //c语言实现，直接内存复制
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Bridge clone = (Bridge)super.clone();
        //深拷贝处理逻辑
        BridgeLocation clone1 = (BridgeLocation)this.location.clone();
        clone.location = clone1;
        return clone;
    }
}

class BridgeLocation implements Cloneable{
    String street;
    int roomNo;

    public BridgeLocation(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
