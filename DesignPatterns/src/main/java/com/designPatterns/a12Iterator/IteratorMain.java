package com.designPatterns.a12Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 迭代器
 *
 * 真实存在的数据结构：数组和链表(linkedList) --> ArrayList底层是数组
 * 抽象的数据结构：栈，队列，树，图等，都是基于数组或链表或两者结合实现的
 */
public class IteratorMain {
    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("d");

        Iterator<Object> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        List<Object> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(3);

        Iterator<Object> iterator1 = linkedList.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
