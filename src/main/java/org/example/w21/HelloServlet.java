package org.example.w21;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    //HttpServletRequest - 불변
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String msg = "Hello 한글";

        request.setAttribute("msg", msg);

        try {
            request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }
}