package com.example.ss09.repository;

import com.example.ss09.model.Seat;

import java.util.List;

public interface SeatRepository {
    List<Seat> getSeatsByScreenRoom(Long screenRoomId);
    double getSeatPriceById(Long seatId);
    List<Long> getBookedSeatsBySchedule(Long scheduleId);
}
