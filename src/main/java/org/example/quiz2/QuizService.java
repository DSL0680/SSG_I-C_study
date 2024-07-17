package org.example.quiz2;

import java.util.ArrayList;

public enum QuizService {

    INSTANCE;

    private ArrayList<QuizVO> quizVOArrayList;

    QuizService() {
        this.quizVOArrayList = new ArrayList<>();
    }

    public void addQuiz(QuizVO quizVO) {
        quizVOArrayList.add(quizVO);
    }

    public QuizVO getNext() {
        if(quizVOArrayList.isEmpty()) {
            return null;
        }

        return quizVOArrayList.remove(0);
    }

}
