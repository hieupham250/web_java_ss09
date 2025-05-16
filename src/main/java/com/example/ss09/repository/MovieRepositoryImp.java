package com.example.ss09.repository;

import com.example.ss09.connection.ConnectionDB;
import com.example.ss09.model.Movie;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImp implements MovieRepository{
    @Override
    public List<Movie> findAll() {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Movie> movies = new ArrayList<Movie>();
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call find_all_movie()}");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getString("genre"),
                        rs.getString("description"),
                        rs.getInt("duration"),
                        rs.getString("language")
                );
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return movies;
    }

    @Override
    public Movie findById(long id) {
        Connection conn = null;
        CallableStatement cstmt = null;
        Movie movie = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call find_movie_by_id(?)}");
            cstmt.setLong(1, id);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                movie = new Movie(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getString("genre"),
                        rs.getString("description"),
                        rs.getInt("duration"),
                        rs.getString("language")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return movie;
    }
}
