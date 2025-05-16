package com.example.ss09.repository;

import com.example.ss09.connection.ConnectionDB;
import com.example.ss09.model.Customer;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

@Repository
public class LoginRepositoryImp implements LoginRepository {
    @Override
    public Customer login(String username, String password) {
        Connection conn = null;
        CallableStatement cstmt = null;
        Customer customer = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call login(?,?)}");
            cstmt.setString(1, username);
            cstmt.setString(2, password);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                customer = new Customer(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("gender"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return customer;
    }
}
