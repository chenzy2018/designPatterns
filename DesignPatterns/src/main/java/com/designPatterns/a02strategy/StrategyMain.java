package com.designPatterns.a02strategy;

import java.util.Arrays;

/**
 * 策略模式Main
 */
public class StrategyMain {
    public static void main(String[] args) {
        int[] a = {9,2,3,8,5,6,4};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));

        Sorter<Cat> scat = new Sorter<Cat>();
        Cat[] cats = {new Cat(5,5),new Cat(7,7),new Cat(1,1)};
        scat.sort(cats, (c1,c2)->{
            if(c1.wieght > c2.wieght) return 1;
            else if(c1.wieght < c2.wieght) return -1;
            else return 0;
        });
        System.out.println(Arrays.toString(cats));
    }
}
