package com.io;

import java.io.*;

/**
 * @author lb
 * @create 2021-03-13
 */
public class DemoFileOutputSteam {
    public static void main(String[] args) throws IOException {
        OutputStream fos = new FileOutputStream(new File("C:\\Users\\Administrator\\Pictures\\test.txt"),true);
//        fos.write(97);
//        fos.close();

        byte[] byteString = "你好,昆山花桥!".getBytes();
        fos.write(byteString);
        fos.write("\r\n".getBytes());
        fos.close();

    }
}
