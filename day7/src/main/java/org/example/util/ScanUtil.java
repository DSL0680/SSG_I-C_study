package org.example.util;

import java.util.Scanner;

public class ScanUtil {

    private Scanner scanner;

    public ScanUtil(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getStr(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public int getInt(String msg) {
        System.out.println(msg);
        return Integer.parseInt(scanner.nextLine());
    }
    public double getDouble(String msg) {
        System.out.println(msg);
        return Double.parseDouble(scanner.nextLine());
    }
    public void print(Object msg) {
        System.out.println(msg);
    }


}