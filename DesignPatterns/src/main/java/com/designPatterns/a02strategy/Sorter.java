package com.designPatterns.a02strategy;

import java.util.Comparator;

/**
 * 定义了一个排序器，使用排序算法
 */
public class Sorter<T> {

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
