package com.designPatterns.a02strategy;

import java.util.Arrays;
import java.util.Comparator;

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

/**
 * 定义了一个排序器，使用排序算法
 */
class Sorter<T> {

    /**
     * 只能支持int数组，如果要double呢，对Cat对象呢
     */
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;

            for (int j = i+1; j < arr.length; j++) {
                min = arr[j]<(arr[min]) ? j : min;
            }

            swap(arr, i, min);
        }
    }

    private void swap(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    /**
     * 通用方法，要求：传入参数必须实现了Comparable接口
     */
    public void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;

            for (int j = i+1; j < arr.length; j++) {
                min = arr[j].compareTo(arr[min])==-1 ? j : min;
            }

            swap(arr, i, min);
        }
    }

    private void swap(Comparable[] arr, int i, int min) {
        Comparable temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    /**
     * 策略模式
     * 使用的时候传入比较方式
     */
    public void sort(T[] arr, Comparator<T> com) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;

            for (int j = i+1; j < arr.length; j++) {
                min = com.compare(arr[j],arr[min])==-1 ? j : min;
            }

            swap(arr, i, min);
        }
    }

    private void swap(T[] arr, int i, int min) {
        T temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

}

class Cat {

    int wieght;
    int height;

    public Cat(int wieght, int height) {
        this.wieght = wieght;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "wieght=" + wieght +
                ", height=" + height +
                '}';
    }
}