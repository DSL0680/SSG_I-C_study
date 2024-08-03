package org.zerock.demo1.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/check/answer")
@Log4j2
public class CheckAnswerController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String examno = req.getParameter("examno");
        String qnoStr = req.getParameter("qno");
        String answer = req.getParameter("answer");

        HttpSession session = req.getSession();
        String uid = (String)session.getAttribute("uid");

        Cookie answerCookie = Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals("answer"))
                .findFirst().orElse(null);

        //answerCookie가 없다면 잘못된 상황임

        String[] answers = answerCookie.getValue().split("&");

        int qno = Integer.parseInt(qnoStr);

        answers[qno-1] = qno + ":" + answer;

        //다시 문자열을 만들어서 쿠키에 저장
        String cookieValue = String.join("&", answers);

        Cookie answerCookie2 = new Cookie("answer", cookieValue);
        answerCookie2.setPath("/");
        answerCookie2.setMaxAge(60 * 60 * 24);

        resp.addCookie(answerCookie2);

        //DB에 저장 등의 추가적인 작업 수행

        resp.sendRedirect("/exam/answerSheet?count=" + req.getParameter("count"));
    }}
