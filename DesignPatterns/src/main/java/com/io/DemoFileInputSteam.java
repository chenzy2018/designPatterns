package com.io;

import java.io.*;

/**
 * 字节读取流
 * @author lb
 * @create 2021-03-13
 */
public class DemoFileInputSteam {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream(new File("C:\\Users\\Administrator\\Pictures\\test.txt"));
        int len = 0;
       while((len=in.read())!=-1){
           System.out.println((char) len);
       }
        in.close();
    }
}
