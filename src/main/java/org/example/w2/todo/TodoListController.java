package org.example.w2.todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.example.w2.bmi.Scores;

import javax.security.auth.Subject;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@WebServlet(value = "/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       log.info("Todo List GET");

       String tag = "<script src = 'http://49.174.76.109:8080/sample.js'></script>";

       // 1부터10까지를 list배열로 해준거다
        List<Integer> nums =
                IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());

        req.setAttribute("nums", nums);

        req.setAttribute("tag", tag);

       req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);

    }
}
