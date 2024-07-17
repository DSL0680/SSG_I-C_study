package org.example;

import org.example.ex1.ChRest;
import org.example.ex1.GunsanRest;
import org.example.ex1.SeoulRest;
import org.example.quiz.Quiz;
import org.example.quiz2.*;
import org.example.quiz2.QuizUI2;

import java.util.Scanner;

public class Main {

    public static void testZazang(ChRest chRest) {

        chRest.makeZazang();

    }

    public static void main(String[] args) {

        QuizService.INSTANCE.addQuiz(new SQuizVO("Q1...", "y"));
        QuizService.INSTANCE.addQuiz(new MQuizVO("Q2...", "AAA","AAA", "BBB"));

        Scanner scanner = new Scanner(System.in);
        QuizUI2 quizUI = new QuizUI2(scanner);

        quizUI.show();












//        ChRest rest1 = new ChRest();
//        rest1.makeZazang();
//
//        ChRest rest2 = new SeoulRest();
//        rest2.makeZazang();
//
//        ChRest rest3 = new SeoulRest();
//        rest3.makeZazang();






//        QuizService.INSTANCE.addQuiz(new Quiz("Q1..", "y"));
//        QuizService.INSTANCE.addQuiz(new Quiz("Q2..", "y"));
//        QuizService.INSTANCE.addQuiz(new Quiz("Q3..", "y"));
//        QuizService.INSTANCE.addQuiz(new Quiz("Q4..", "y"));
//        QuizService.INSTANCE.addQuiz(new Quiz("Q5..", "y"));
//
//        Scanner scanner = new Scanner(System.in);
//        QuizUI.INSTANCE.initialize(scanner);
//        QuizUI.INSTANCE.show();
//        QuizUI quizUI = new QuizUI(scanner);
//
//        quizUI.show();
    }
}