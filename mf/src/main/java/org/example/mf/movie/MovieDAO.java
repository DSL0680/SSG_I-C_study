package org.example.mf.movie;

import lombok.Cleanup;
import org.example.mf.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public enum MovieDAO {
    INSTANCE;

    public Optional<MovieVO> get(String uid, String upw) throws Exception {

        String query = """
                select * from tbl_movie_member
                where uid = ?
                and upw = ?
                and delflag = false
                """;
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, uid);
        ps.setString(2, upw);

        @Cleanup ResultSet rs = ps.executeQuery();

        if ( ! rs.next()) {
            return Optional.empty();
        }

        MovieVO movie = MovieVO.builder()
                .mno(rs.getInt("mno"))
                .uid(rs.getString("uid"))
                .upw(rs.getString("upw"))
                .name(rs.getString("name"))
                .delFlag(rs.getBoolean("delflag"))
                .build();
        return Optional.of(movie);

    }
}
