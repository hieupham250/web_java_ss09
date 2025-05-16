package com.example.ss09.repository;

import com.example.ss09.connection.ConnectionDB;
import com.example.ss09.model.ScreenRoom;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScreenRoomRepositoryImp implements ScreenRoomRepository {
    @Override
    public List<ScreenRoom> findAll() {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<ScreenRoom> screenRooms = new ArrayList<ScreenRoom>();
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call find_all_screenRoom()}");
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                ScreenRoom screenRoom = new ScreenRoom(
                        rs.getLong("id"),
                        rs.getString("screenRoomName"),
                        rs.getInt("totalSeat")
                );
                screenRooms.add(screenRoom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return screenRooms;
    }
}
