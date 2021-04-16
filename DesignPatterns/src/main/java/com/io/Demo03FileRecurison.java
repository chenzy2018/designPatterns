package com.io;

/**
 * 递归求和 1+。。。+n的和
 *
 * @author lb
 * @create 2021-03-13
 */
public class Demo03FileRecurison {

    public static void main(String[] args) {
        System.out.println(sum(5));


    }


    public static int sum(int n) {

        if (n == 1) {
            return 1;
        }

        return n + sum(n - 1);


    }

}
