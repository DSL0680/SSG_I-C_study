package org.example.w2.todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.example.w2.bmi.Scores;
import org.example.w2.common.PageInfo;
import org.example.w2.common.StringUtil;
import org.example.w2.todo.dao.TodoDAO;

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

       String pageStr = req.getParameter("page");

       log.info("pageStr: " + pageStr);

       int page = StringUtil.getInt(pageStr, 1);

       try {

           int total = TodoDAO.INSTANCE.getTotal();

           PageInfo pageInfo = new PageInfo(page,10, total);

           req.setAttribute("list", TodoDAO.INSTANCE.list(pageInfo.getPage()));

           req.setAttribute("pageInfo", pageInfo);

           req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
       }catch (Exception e) {
           e.printStackTrace();
       }//end catch


    }
}


//String tag = "<script src = 'http://49.174.76.109:8080/sample.js'></script>";
//
//       // 1부터10까지를 list배열
//        List<Integer> nums =
//                IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
//
//        req.setAttribute("nums", nums);
//
//        req.setAttribute("tag", tag);