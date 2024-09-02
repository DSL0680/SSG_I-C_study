package org.example.w21.todo.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.example.w21.common.ConnectionUtil;
import org.example.w21.todo.TodoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public enum TodoDAO {
    INSTANCE;

    TodoDAO() {

    }

    public List<TodoVO> list(int page) throws Exception {
        log.info("list");

        int skip = (page - 1) * 10;

        String query = """
                select * 
                from todo_tbl
                where tno > 0 
                  and delflag = false
                order by 
                    tno desc 
                limit ?,10""";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, skip);
        @Cleanup ResultSet rs = ps.executeQuery();


        List<TodoVO> list = new ArrayList<>();

        while (rs.next()) {
            TodoVO vo = TodoVO.builder()
                    .tno(rs.getInt("tno"))
                    .title(rs.getString("title"))
                    .writer(rs.getString("writer"))
                    .regdage(rs.getTimestamp("regdage"))
                    .moddate(rs.getTimestamp("moddate"))
                    .delflag(rs.getBoolean("delflag"))
                    .build();
            list.add(vo);
        }//end while


        return list;
    }
    public int getTotal() throws Exception {
        log.info("getTotal");

        String query = "select count(tno)\n" +
                "from todo_tbl\n" +
                "where tno > 0\n" +
                "  and delflag = false";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        @Cleanup ResultSet rs = ps.executeQuery();

        rs.next();

        int total = rs.getInt(1);

        return total;
    }

}
