package org.example.quiz;

import java.util.ArrayList;

public enum QuizService {
    //객체를 몇 개나 만들거냐
    INSTANCE;

    private ArrayList<Quiz> quizList;

    QuizService() {
        quizList = new ArrayList<>();
    }

    //문제를 추가하는 기능 - 붓는다.
    public void addQuiz(Quiz quiz) {
        quizList.add(quiz);
    }

    //문제를 꺼내는 기능 - 꺼낸다.
    public Quiz getQuiz() {

        if(quizList.isEmpty()) {
            return null;
        }

        return quizList.remove(0);
    }



}
