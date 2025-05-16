package com.example.ss09.repository;

import com.example.ss09.connection.ConnectionDB;
import com.example.ss09.model.Schedule;
import com.example.ss09.model.ScreenRoom;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleRepositoryImp implements ScheduleRepository {
    @Override
    public List<Schedule> findAllScheduleByMovie(Long movieId) {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Schedule> schedules = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call find_schedule_by_movie(?)}");
            cstmt.setLong(1, movieId);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule(
                        rs.getLong("id"),
                        rs.getLong("movieId"),
                        rs.getString("movieTitle"),
                        rs.getTimestamp("showTime"),
                        rs.getLong("screenRoomId"),
                        rs.getInt("availableSeats"),
                        rs.getString("format")
                );
                schedules.add(schedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return schedules;
    }
}
