package org.example;


public class Main {

    public static void doA() {
        for (int i = 1; i <= 500; i++) {
            System.out.println(Thread.currentThread().getName() + "  i = " + i);
        }
    }

    public static void doB() {

        System.out.println("start.............." + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("end.............." + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 4; i++) {
            new Thread(() -> doB()).start();
        }


    }
}