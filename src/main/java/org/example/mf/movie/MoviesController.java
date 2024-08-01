package org.example.mf.movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/movies")
@Log4j2
public class MoviesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String uid = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("uid".equals(cookie.getName())) {
                    uid = cookie.getValue();
                    break;
                }
            }
        }

        if (uid == null) {
            resp.sendRedirect("/signIn");
            return;
        }

        try {
            List<MovieInfoVO> movieList = MoviesDAO.INSTANCE.getAllMovies();
            req.setAttribute("movies", movieList);
            req.getRequestDispatcher("/WEB-INF/movie/movies.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("Error fetching movies", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}