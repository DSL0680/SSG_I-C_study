package org.example.mf.movie;

import jakarta.servlet.ServletException;
import lombok.Cleanup;
import org.example.mf.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum MoviesDAO {
    INSTANCE;

    public List<MovieInfoVO> getAllMovies() throws SQLException {
        String query = "SELECT * FROM tbl_movieInfo";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);

        @Cleanup ResultSet rs = ps.executeQuery();
        List<MovieInfoVO> movies = new ArrayList<>();
        while (rs.next()) {
            MovieInfoVO movie = MovieInfoVO.builder()
                    .mid(rs.getInt("mid"))
                    .title(rs.getString("title"))
                    .path(rs.getString("image_path"))
                    .build();
            movies.add(movie);
        }
        return movies;
    }

    public void addPurchase(int userId, int movieId) throws SQLException {
        String query = "INSERT INTO tbl_purchases (user_id, movie_id) VALUES (?, ?)";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, userId);
        ps.setInt(2, movieId);
        ps.executeUpdate();
    }

    public List<MovieInfoVO> getPurchasedMovies(int userId) throws SQLException {
        String query = """
                SELECT mid, title, path
                FROM tbl_purchases p
                JOIN tbl_movies m ON p.movie_id = m.movie_id
                WHERE p.user_id = ?
                """;
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, userId);

        @Cleanup ResultSet rs = ps.executeQuery();
        List<MovieInfoVO> movies = new ArrayList<>();
        while (rs.next()) {
            MovieInfoVO movie = MovieInfoVO.builder()
                    .mid(rs.getInt("movie_id"))
                    .title(rs.getString("title"))
                    .path(rs.getString("image_path"))
                    .build();
            movies.add(movie);
        }
        return movies;
    }
}