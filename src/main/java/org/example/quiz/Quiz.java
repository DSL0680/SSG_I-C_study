package org.example.quiz;

public record Quiz(String text, String answer) {


    public boolean checkAnswer(String answer) {

        return answer.equals(this.answer);

    }

}
