package org.example.quiz;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuizVO {
    private final String question;  // 퀴즈 질문을 담는 필드
    private int answer;             // 사용자 입력값을 담는 필드 (1: O, 2: X)

    public QuizVO(String question, int answer) {
        this.question = question;
        this.answer = answer;
    }
}
