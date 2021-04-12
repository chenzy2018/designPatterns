package com.designPatterns.a05Mediator;

import com.designPatterns.User;

import java.util.Date;
/**
 * 中介类
 */
public class ChatRoom {

    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}
