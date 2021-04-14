package com.designPatterns.a05Mediator;

import com.designPatterns.User;

import java.util.Date;

/**
 * 中介者模式：mq就是典型案例，将网状变成星状
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}

/**
 * 中介类
 */
class ChatRoom {

    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}