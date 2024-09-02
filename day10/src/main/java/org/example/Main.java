package org.example;


import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    //bad code
    public static void main(String[] args) throws Exception {

        FileInputStream fin = new  FileInputStream("target.jpg");
        FileOutputStream fout = new FileOutputStream("copy.jpg");

        System.out.println(fin);

        byte[] buffer = new byte[8192]; //1kb

        long start = System.currentTimeMillis();

        while (true) {

           int count = fin.read(buffer); //새로 몇 개나 채워졌나의 의미

            System.out.println(count);

           if (count == -1) break;

           fout.write(buffer, 0 ,count); //새로 채운 만큼만 써라.

        }//end while

        long end = System.currentTimeMillis();

        System.out.println("TIME: " + (end - start));
    }
}