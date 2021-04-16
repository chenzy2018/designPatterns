package com.io;

import java.io.*;

/**
 * 文件复制,可以使用字节数组进行缓冲，提升效率
 * @author lb
 * @create 2021-03-13
 */
public class FileCope {
    public static void main(String[] args) throws IOException {

        cope2("F:\\迅雷下载\\[BD影视分享bd2020.com]牧马人.The.Herdsman.1982.无台标.HD1080P.国语中字.mp4", "E:\\cc.mp4");
    }

    public static void cope(String source, String target) throws IOException {
        long s1 = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream(source);
        OutputStream fos = new FileOutputStream(target);
        int len = 0;
        while ((len = fileInputStream.read()) != -1) {
            fos.write(len);
        }
        fos.close();
        fileInputStream.close();
        long s2 = System.currentTimeMillis();
        System.out.println("复制完成总共消耗："+(s2-s1));
    }


    public static void cope2(String source, String target) throws IOException {
        long l = System.currentTimeMillis();
        InputStream ins = new FileInputStream(source);
        OutputStream fos = new FileOutputStream(target);

        int len = 0 ;
        byte[] bytes = new byte[1024];

        while ((len = ins.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        long l2 = System.currentTimeMillis();
        fos.close();
        ins.close();
        System.out.println("复制完成总消耗时间："+(l2-l));

    }

}
