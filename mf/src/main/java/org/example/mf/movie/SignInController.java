package org.example.mf.movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/signIn")
@Log4j2
public class SignInController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/movie/signIn.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");

        //JSESSION_ID 가 세션저장소에 있으면 반환,없으면 생성
        HttpSession session = req.getSession();

//DB에서 해당 사용자 정보를 확인해서 사용자정보를 얻어온다.
        try {
            Optional<MovieVO> result = MovieDAO.INSTANCE.get(uid, upw);
            result.ifPresentOrElse(memberVO -> {
                Cookie loginCookie = new Cookie("movie", uid);
                loginCookie.setPath("/");
                loginCookie.setMaxAge(60 * 60 * 24);
                resp.addCookie(loginCookie);
                try {
                    resp.sendRedirect("/movies");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }, () -> {
                try {
                    resp.sendRedirect("/signIn");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

