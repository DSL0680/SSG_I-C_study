package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class ListEx {

    public static void main(String[] args) {

        //제네릭 - 내가 사용하는 타입은 Integer
        ArrayList<Integer> List = new ArrayList<Integer>();


        for (int i = 1; i <= 45; i++) {
            List.add(i);
        }

        Collections.shuffle(List);

        System.out.println(List);

        System.out.println("size: " + List.size());

        //순서가 맨 앞
        int size = List.size();

        for (int i = 0; i < 6; i++) {
            System.out.println(List.remove(0));
        }






//        List.add(1, Integer.valueOf(100));
//
//        System.out.println(List);
//
//        List.set(2, Integer.valueOf(200));
//        System.out.println(List);
//
//        int idx = List.indexOf(Integer.valueOf(100));
//        System.out.println(idx);

    }
}
