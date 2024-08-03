package org.zerock.demo1.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.extern.log4j.Log4j2;
import org.zerock.demo1.util.StringUtil;
import org.zerock.demo1.vo.QuizVO;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@WebServlet("/exam/view")
@Log4j2
public class ExamViewController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession(false);

        int examNum = (int)session.getAttribute("examNum");


        java.util.List<QuizVO> quizVOList = IntStream.rangeClosed(1, 10).mapToObj(i -> QuizVO.builder()
                    .qno( i )
                    .question("문제" + i)
                    .op1("1번" + i)
                    .op2("2번" + i)
                    .op3("3번" + i)
                    .op4("4번" + i)
                    .op5("5번" + i)
                    .answer(i % 5 + 1)
                    .build()).collect(Collectors.toList());

        req.setAttribute("quizList", quizVOList);

        //임시로 만드는 사용자의 답안지는 쿠키를 통해서 유지
        String cookieValue = quizVOList.stream().map(vo -> vo.getQno()+":0").collect(Collectors.joining("&"));

        Cookie answerCookie = new Cookie("answer", cookieValue);
        answerCookie.setPath("/");
        answerCookie.setMaxAge(60 * 60 * 24);

        resp.addCookie(answerCookie);


        req.getRequestDispatcher("/WEB-INF/exam/view.jsp").forward(req, resp);



    }
}
