package com.designPatterns.a18Prototype;

/**
 * 浅拷贝：只复制对象，不关注对象内部的属性
 */
public class ShallowClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person().baseInfo(18,"jack").locationInfo(new Location("sd",38)).build();

        Person p2 = (Person) p1.clone();

        //浅拷贝下引用属性是不会拷贝，因此一样
        System.out.println(p1.location == p2.location);
        p1.location.street = "de";
        System.out.println(p2.location.street);//受b1的改动影响
    }
}

//Cloneable是一个标记接口(空接口，没有定义一个方法)
class Person implements Cloneable{
    int age;
    String name;

    Location location;

    //建造者模式
    public Person baseInfo(int age, String name){
        this.age = age;
        this.name = name;
        return this;
    }
    public Person locationInfo(Location location){
        this.location = location;
        return this;
    }
    public Person build(){
        return this;
    }

    //拷贝函数，必须要实现Cloneable，才能调用，不然运行时会报错
    //c语言实现，直接内存复制
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Location{
    String street;
    int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}
