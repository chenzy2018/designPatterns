package com.io;

import java.io.File;

/**
 * 求阶乘n!
 *
 * @author lb
 * @create 2021-03-13
 */
public class Demo03FileRecurison02 {

    public static void main(String[] args) {

        File file = new File("F:\\cope\\bin\\com\\zlink\\web");

        getAllFiles(file);
    }


    public static void getAllFiles(File file) {
        File[] files = file.listFiles((o)->
            o.getName().toLowerCase().endsWith(".class")
        );


        for (File file1 : files) {
            if(file1.isDirectory()){
                System.out.println(file1);
                getAllFiles(file1);
            }else{

                System.out.println( file1.getName());
            }
        }



    }

}
