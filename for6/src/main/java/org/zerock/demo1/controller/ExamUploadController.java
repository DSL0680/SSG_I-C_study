package org.zerock.demo1.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.zerock.demo1.util.ExcelReader;
import org.zerock.demo1.vo.QuizVO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/exam/upload")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB
        maxFileSize=1024*1024*50,      	// 50 MB
        maxRequestSize=1024*1024*100)   	// 100 MB

@Log4j2
public class ExamUploadController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part filePart = req.getPart("examFile");


        @Cleanup  InputStream in = filePart.getInputStream();


        try {
            List<QuizVO> quizVOList = ExcelReader.readInputStream(in);

            log.info(quizVOList);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
