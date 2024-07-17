package org.example;

import org.example.quiz.QuizData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class QuizTests2 {

    QuizData first;

    @BeforeEach
    public void setUp() {
        first = new QuizData("달팽이도 이빨이 있다.", 1);
        QuizData q2 = new QuizData("멧돼지는 영어로 Wild boar이다", 1);
        QuizData q3 = new QuizData("토마토는 과일이다", 2);
        QuizData q4 = new QuizData("킹크랩은 게의 한 종류이다", 2);
        QuizData q5 = new QuizData("뱀은 귀가없어서 소리를 듣지 못한다", 2);
        QuizData q6 = new QuizData("바나나에는 씨앗이 있다", 1);

        first.setNext(q2);
        q2.setNext(q3);
        q3.setNext(q4);
        q4.setNext(q5);
        q5.setNext(q6);

    }
    @Test
    public void test2() {

        QuizData current = first;

        Scanner sc = new Scanner(System.in);

        while(true) {

            if(current == null) {
                break;
            } else {
                current = current.checkAnswer(1);
                if(current != null) {
                    System.out.println("정답!!!!!!!!");
                }
            }



        }//end while
    }



}
