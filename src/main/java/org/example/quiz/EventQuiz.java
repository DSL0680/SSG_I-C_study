package org.example.quiz;

public class EventQuiz implements Quiz{
    
    @Override
    public String getText() {
        return "";
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return false;
    }
}
