//package org.example;
//
//
//import lombok.extern.log4j.Log4j2;
//import org.example.quiz.QuizVO;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//@Log4j2
//public class QuizTests {
//
//    QuizVO first;
//
//    @BeforeEach
//    public void setUp() {
//        first = new QuizVO("First Quiz");
//
//        QuizVO q2 = new QuizVO("2nd Quiz");
//        QuizVO q3 = new QuizVO("3rd Quiz");
//        QuizVO q4 = new QuizVO("4th Quiz");
//        QuizVO q5 = new QuizVO("5th Quiz");
//        QuizVO q6 = new QuizVO("6th Quiz");
//
//        first.setYes(q2);
//        q2.setYes(q3);
//        q3.setYes(q4);
//        q4.setYes(q5);
//        q5.setYes(q6);
//
//
//    }
//
//    @Test
//    public void test1() {
//
//        QuizVO current = first;
//
//        while(true) {
//            if(current == null) {
//                break;
//            }
//            log.info(current.getText());
//
//            current = current.getNext("y");
//
//        }//end while
//
//    }//end test1
//
//}
