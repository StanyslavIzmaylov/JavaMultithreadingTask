package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        Charset koi8 = Charset.forName("Windows-1251");
        Charset windows1251 = Charset.forName("UTF-8");
        while (fileInputStream.available() > 0){
            byte[] buffer = new byte[1000];
            fileInputStream.read(buffer);
            String s = new String(buffer, koi8);
            buffer = s.getBytes(windows1251);
            fileOutputStream.write(buffer);
        }
    }
}
