package com.designPatterns.a13Visitor;

/**
 * 观察者模式
 *
 * 需求：实现不同客户组装电脑，可以得到的优惠不同
 */
public class VisitorMain {

    private VisitorMain(){}
    static class VisitorMainStatic {
        static final VisitorMain instance = new VisitorMain();
    }

    public void addVisitor(Visitor v){
        CPU.CPUStatic.instance.visitorPart(v);
        Memery.MemeryStatic.instance.visitorPart(v);
        Board.BoardStatic.instance.visitorPart(v);
    }

    public static void main(String[] args) {

        Student student = new Student();
        VisitorMainStatic.instance.addVisitor(student);
        System.out.println(student.totalPrice);

        Teacher teacher = new Teacher();
        VisitorMainStatic.instance.addVisitor(teacher);
        System.out.println(teacher.totalPrice);

    }
}

//电脑组成部分，比如cpu，内存，主板
interface ComputerPart{

    void visitorPart(Visitor v);//加入观察者，如果不加，就需要if判断不同情况做不同优惠，代码不好维护且有侵入

    double getPrice();
}
class CPU implements ComputerPart{
    private CPU(){}
    static class CPUStatic{
        static final CPU instance = new CPU();
    }

    @Override
    public void visitorPart(Visitor v) {
        v.visitorCpu(this);
    }

    @Override
    public double getPrice() {
        return 500;
    }
}
class Memery implements ComputerPart{

    private Memery(){}
    static class MemeryStatic{
        static final Memery instance = new Memery();
    }

    @Override
    public void visitorPart(Visitor v) {
        v.visitorMemery(this);
    }

    @Override
    public double getPrice() {
        return 500;
    }
}
class Board implements ComputerPart{

    private Board(){}
    static class BoardStatic{
        static final Board instance = new Board();
    }

    @Override
    public void visitorPart(Visitor v) {
        v.visitorBoard(this);
    }

    @Override
    public double getPrice() {
        return 500;
    }
}

//观察者
interface Visitor{
    void visitorCpu(CPU cpu);
    void visitorMemery(Memery memery);
    void visitorBoard(Board board);
}
class Student implements Visitor{
    double totalPrice ;

    @Override
    public void visitorCpu(CPU cpu) {
        totalPrice += cpu.getPrice()*0.5;
    }

    @Override
    public void visitorMemery(Memery memery) {
        totalPrice += memery.getPrice()*0.5;
    }

    @Override
    public void visitorBoard(Board board) {
        totalPrice += board.getPrice()*0.5;
    }
}
class Teacher implements Visitor{
    double totalPrice ;

    @Override
    public void visitorCpu(CPU cpu) {
        totalPrice += cpu.getPrice()*0.75;
    }

    @Override
    public void visitorMemery(Memery memery) {
        totalPrice += memery.getPrice()*0.75;
    }

    @Override
    public void visitorBoard(Board board) {
        totalPrice += board.getPrice()*0.75;
    }
}

//如果需要新加一种优惠方案，就非常好扩展
class Police implements Visitor{
    double totalPrice ;

    @Override
    public void visitorCpu(CPU cpu) {
        totalPrice += cpu.getPrice()*0.65;
    }

    @Override
    public void visitorMemery(Memery memery) {
        totalPrice += memery.getPrice()*0.65;
    }

    @Override
    public void visitorBoard(Board board) {
        totalPrice += board.getPrice()*0.65;
    }
}