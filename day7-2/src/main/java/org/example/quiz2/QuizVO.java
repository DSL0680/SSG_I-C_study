package org.example.quiz2;

public class QuizVO {

    protected String text;
    protected String answer;

    public QuizVO(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }

    public String getText() {
        return this.text;
    }


    public boolean checkAnswer(String answer) {
        return this.answer.equals(answer);
    }
}
