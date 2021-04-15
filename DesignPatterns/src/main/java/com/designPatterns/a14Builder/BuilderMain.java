package com.designPatterns.a14Builder;

/**
 * 建造者模式：用于构建复杂对象
 */
public class BuilderMain {

    public static void main(String[] args) {
        Person p = new Person.PersonBuilder()
                .baseInfo("dsf",18)
                .heightInfo(178)
                .weightInfo(120)
                .locationInfo("sdf",12)
                .builde();

        System.out.println(p.toString());
    }
}

//人
class Person{
    String name;
    int age;
    int weight;
    int height;
    Location location;

    private Person(){}

    public static class PersonBuilder{
        public Person p = new Person();

        public PersonBuilder baseInfo(String name, int age){
            p.age = age;
            p.name = name;
            return this;
        }

        public PersonBuilder weightInfo(int weight){
            p.weight = weight;
            return this;
        }

        public PersonBuilder heightInfo(int height){
            p.height = height;
            return this;
        }

        public PersonBuilder locationInfo(String street, int roomNo){
            p.location = new Location(street,roomNo);
            return this;
        }

        public Person builde(){
            return p;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", location=" + location.toString() +
                '}';
    }
}

//地址
class Location{
    String street;
    int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }
}