package com.example.ss09.repository;

import com.example.ss09.connection.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class TicketRepositoryImp implements TicketRepository {
    @Override
    public void createTicket(Long customerId, Long scheduleId, Long seatId, Double totalMoney) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call create_ticket(?, ?, ?, ?)}");
            cstmt.setLong(1, customerId);
            cstmt.setLong(2, scheduleId);
            cstmt.setLong(3, seatId);
            cstmt.setDouble(4, totalMoney);
            cstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
    }
}
