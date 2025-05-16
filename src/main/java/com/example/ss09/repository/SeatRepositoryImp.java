package com.example.ss09.repository;

import com.example.ss09.connection.ConnectionDB;
import com.example.ss09.model.Seat;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SeatRepositoryImp implements SeatRepository {
    @Override
    public List<Seat> getSeatsByScreenRoom(Long screenRoomId) {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Seat> seats = new ArrayList<Seat>();
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call find_seats_by_screenroom(?)}");
            cstmt.setLong(1, screenRoomId);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Seat seat = new Seat(
                        rs.getLong("id"),
                        rs.getLong("screenRoomId"),
                        rs.getDouble("price"),
                        rs.getString("status")
                );
                seats.add(seat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return seats;
    }

    @Override
    public double getSeatPriceById(Long seatId) {
        Connection conn = null;
        CallableStatement cstmt = null;
        double price = 0;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call get_seat_price_by_id(?)}");
            cstmt.setLong(1, seatId);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("price");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return price;
    }

    @Override
    public List<Long> getBookedSeatsBySchedule(Long scheduleId) {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Long> bookedSeatIds = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call get_booked_seats_by_schedule(?)}");
            cstmt.setLong(1, scheduleId);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                bookedSeatIds.add(rs.getLong(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return bookedSeatIds;
    }
}
