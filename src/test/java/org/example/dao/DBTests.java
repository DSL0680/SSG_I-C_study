package org.example.dao;


import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.example.w2.bmi.Scores;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Log4j2
public class DBTests {

    @Test
    public void testSelect() throws Exception {
        String url = "jdbc:mariadb://49.174.76.109:13306/webdb";
        String username = "webdbuser";
        String password = "webdbuser";

        Class.forName("org.mariadb.jdbc.Driver");

        String sql = "select * from tbl_todo where tno > 0 order by tno desc";

        long start = System.currentTimeMillis();

        @Cleanup Connection con = DriverManager.getConnection(url, username, password);
        @Cleanup PreparedStatement ps = con.prepareStatement(sql);
        @Cleanup ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            log.info(rs.getInt(1)); //tno
            log.info(rs.getString(2)); //title
            log.info(rs.getString(3)); //writer
//            log.info(rs.getTimestamp(4));
//            log.info(rs.getTimestamp(5));
//            log.info(rs.getBoolean(6));


        }//end while

        long end = System.currentTimeMillis();

        log.info("-------------------");
        log.info(end - start);
    }



    @Test
    public void testRemote() throws Exception {

        @Cleanup Scores scores = new Scores();

        int[] arr = {1, 2, 3};

        log.info(arr[3]);

    }



    @Test
    public void testInsert() throws Exception {

        String sql = "insert into tbl_todo (title, writer)" +
                "                  values (?,?)";

        String url = "jdbc:mariadb://localhost:13306/webdb";
        String username = "webdbuser";
        String password = "webdbuser";

        Class.forName("org.mariadb.jdbc.Driver");


        //Socket
        @Cleanup Connection con = DriverManager.getConnection(url, username, password);
        @Cleanup PreparedStatement ps = con.prepareStatement(sql);


        ps.setString(1, "해야하는 일");
        ps.setString(2, "writer");

        int count = ps.executeUpdate();

        log.info("COUNT: " + count);

        //테스트의 성공 조건
        Assertions.assertEquals(count, 1);


    }
}



//        String url = "jdbc:mariadb://49.174.76.109:13306/webdb";
//        String username = "webdbuser";
//        String password = "webdbuser";
//
//        Class.forName("org.mariadb.jdbc.Driver");
//
//        long start = System.currentTimeMillis();
//
//        for (int i = 0; i < 100; i++) {
//
//            @Cleanup Connection conn = DriverManager.getConnection(url, username, password);
//
//            log.info(conn);
//
//        }
//        long end = System.currentTimeMillis();
//
//        log.info("Time: " + (end - start));