package com.io;

import java.io.File;

/**
 * 文件流
 * 创建文件 以及删除文件
 * 创建目录 以及删除目录
 * 获取文件信息
 * @author lb
 * @create 2021-03-13
 */
public class DemoFile {
    public static void main(String[] args) {
        String pathSeparator = File.pathSeparator;
        char pathSeparatorChar = File.pathSeparatorChar;
        System.out.println(pathSeparatorChar);
        System.out.println(pathSeparator);
        String separator = File.separator;
        System.out.println(separator);
        //绝对路径C:\\a.txt

        //相对路径 a.txt

        //File 构造方法

        File file = new File("F:\\lb.txt");
        System.out.println("----"+file);

        File file2 = new File("F:\\TGA");
        System.out.println("----"+file2);


        File file3 = new File("F:\\TGA","aa");
        System.out.println("----"+file3);


    }

}
