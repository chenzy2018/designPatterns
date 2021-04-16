package com.io;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;

/**
 * @author lb
 * @create 2021-03-13
 */
public class Demo02Fille {
    public static void main(String[] args) throws IOException {
        show01();
    }

    public static void  show01() throws IOException {
//        File file = new File("C:\\Users\\Administrator\\Pictures\\300381.jpg");
//        System.out.println(file.length());
//        System.out.println( new File("C:\\Users\\Administrator\\Pictures\\3003812.jpg").exists());
//        //判断文件是否真实存在的
//        System.out.println( new File("C:\\Users\\Administrator\\Pictures\\aa").isDirectory());
//        //判断文件是否真实存在的
//        System.out.println( new File("C:\\Users\\Administrator\\Pictures\\300381.jpg").isFile());
//
//        File file1 = new File("C:\\Users\\Administrator\\Pictures\\cc.jpg");
//        file1.createNewFile();
//        file1.delete();

//        File file2 = new File("C:\\Users\\Administrator\\Pictures\\cc\\aa");
//        System.out.println(file2.mkdir());
//
//        File file3 = new File("C:\\Users\\Administrator\\Pictures\\aa\\bb\\vv");
//
//        System.out.println(file3.mkdirs());
//        file3.delete();
        File file = new File("F:\\QQ");
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }


    }
}
