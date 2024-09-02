package org.example.quiz;

import java.util.Scanner;

public enum QuizUI {

    INSTANCE;

    private Scanner scanner;

    // 스캐너 초기화 메서드
    public void initialize(Scanner scanner) {
        this.scanner = scanner;
    }

    public void show() {
        System.out.println("Welcome to the Quiz Show");

        // 문제를 가져와야 함
        while (true) {
            Quiz quiz = QuizService.INSTANCE.getQuiz();

            if (quiz == null) {
                System.out.println("You are Quiz King");
                break;
            } else {
                System.out.println(quiz.text());
                String userAnswer = scanner.nextLine();
                boolean result = quiz.checkAnswer(userAnswer);
                if (!result) {
                    System.out.println("Wrong answer Back Home");
                    break;
                }
            }
        } // end while
    } // end show
}
