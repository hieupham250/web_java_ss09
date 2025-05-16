package com.example.ss09.service;

import com.example.ss09.model.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getSeatsByScreenRoom(Long screenRoomId);
    double getSeatPriceById(Long seatId);
    List<Long> getBookedSeatsBySchedule(Long scheduleId);
}
