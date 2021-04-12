package com.designPatterns.a07Responsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 */
public class ResponsibilityMain {

    public static void main(String[] args) {

        Msg msg = new Msg();
        msg.setMsg("大家好:），<script> 今天我来了，996");
        /**
         * 需求：
         *   1.替换<，防止XSS攻击
         *   2.替换敏感词汇996
         *   3.替换表情
         *   4.需要做到可以由某一个拦截控制是否往下执行
         */

        //简单实现
        // List<Filter> list = new ArrayList<>();
        // list.add(new CharFllter());
        // list.add(new WordFllter());
        // list.add(new FaceFllter());
        // for(Filter f : list){
        //     f.doFilter(msg);
        // }
        // System.out.println(msg);

        //责任链
        FilterChain filterChain1 = new FilterChain();
        filterChain1.add(new CharFllter()).add(new WordFllter());//因为返回了FilterChain对象
        FilterChain filterChain2 = new FilterChain();
        filterChain2.add(new FaceFllter());
        filterChain1.add(filterChain2);//直接加入一个责任链，因为FilterChain也实现了Filter接口
        filterChain1.doFilter(msg);
        System.out.println(msg);
    }
}

//模拟一条请求锁包含的内容
class Msg{
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter{
    boolean doFilter(Msg m);//boolean用于控制是否往下执行
}

//字符替换，半条变全角
class CharFllter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        m.setMsg(m.getMsg().replaceAll("<","＜"));
        m.setMsg(m.getMsg().replaceAll(">","＞"));
        return true;//简单写了，应该有逻辑控制true/false
    }
}

class WordFllter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        m.setMsg(m.getMsg().replaceAll("996","965"));
        return false;
    }
}

class FaceFllter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        m.setMsg(m.getMsg().replaceAll(":）","＾ｖ＾"));
        return true;
    }
}

class FilterChain implements Filter{
    List<Filter> list = new ArrayList<>();

    public FilterChain add(Filter f){
        list.add(f);
        return this;//返回FilterChain对象，是为了可以简写add
    }

    @Override
    public boolean doFilter(Msg m) {
        for(Filter f : list){
            if(!f.doFilter(m)) return false;//控制是否往下执行
        }
        return true;
    }
}