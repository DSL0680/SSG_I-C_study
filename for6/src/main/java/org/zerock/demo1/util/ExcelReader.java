package org.zerock.demo1.util;

import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.zerock.demo1.vo.QuizVO;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Log4j2
public class ExcelReader {

    public static List<QuizVO> readInputStream(InputStream in)throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook(in);

//Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

//Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();


        log.info(rowIterator);

        //1번행은 제목이므로 skip
        rowIterator.next();

        List<QuizVO> quizVOList = new ArrayList<>();


        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if(row.getCell(0) == null){
                break;
            }

            int idx = 0;

            QuizVO vo = QuizVO.builder()
                    .qno((int)(int)row.getCell(idx++).getNumericCellValue())
                    .question(row.getCell(idx++).getStringCellValue())
                    .op1(row.getCell(idx++).getStringCellValue())
                    .op2(row.getCell(idx++).getStringCellValue())
                    .op3(row.getCell(idx++).getStringCellValue())
                    .op4(row.getCell(idx++).getStringCellValue())
                    .op5(row.getCell(idx++).getStringCellValue())
                    .answer((int)(row.getCell(idx++).getNumericCellValue()))
                    .build();

            log.info("---------------------");
            log.info(vo);

            quizVOList.add(vo);
        }


        return quizVOList;

    }


}
