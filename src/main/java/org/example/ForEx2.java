package org.example;

public class ForEx2 {

    public static void main(String[] args) {

        loop1:
        for (int i = 0; i < 10; i++) {

            loop2:
            for (int j = 0; j < 5; j++) {
                System.out.println(i + " : " + j);
                if(i == 5) {
                    continue loop1;
                }
            }//end for j


        }//end for

    }//end main

}//end class
