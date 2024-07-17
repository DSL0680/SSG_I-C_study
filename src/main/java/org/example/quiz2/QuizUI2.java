package org.example.quiz2;

import java.util.Scanner;

public class QuizUI2 {

    private Scanner scanner;

    public QuizUI2(Scanner scanner) {
        this.scanner = scanner;

    }

    public void show() {

        while(true) {

            QuizVO quiz = QuizService.INSTANCE.getNext();

            if(quiz == null) {
                System.out.println("The End");
            }

            System.out.println(quiz.getText());

            System.out.println("Insert Your Answer");

            String userAnswer = scanner.nextLine();

            boolean result = quiz.checkAnswer(userAnswer);

            if (result) {
                System.out.println("Your Answer is Correct");
            } else {
                System.out.println("Your Answer is Wrong");
            }

        }//end while
    }

}
