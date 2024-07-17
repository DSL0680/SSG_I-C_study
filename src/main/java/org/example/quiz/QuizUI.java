package org.example.quiz;

import java.util.Scanner;

public class QuizUI {

    public void start(QuizData first) {
        Scanner sc = new Scanner(System.in);
        QuizData current = first;
        int cnt = 0;
        while(true) {

            if(current == null && cnt == 7) {
                System.out.println("모두 맞추셨습니다.");
                break;
            } else if(current == null){
                System.out.println("틀렸습니다.");
                break;
            }else{
                System.out.println(current.getQuestion());
                int input= sc.nextInt();
                current = current.checkAnswer(input);
                if(current != null) {
                    System.out.println("정답입니다");
                }
                cnt+=1;
            }//end else


        }


    }
}