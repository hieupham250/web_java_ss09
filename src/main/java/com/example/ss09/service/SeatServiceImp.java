package com.example.ss09.service;

import com.example.ss09.model.Seat;
import com.example.ss09.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImp implements SeatService {
    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<Seat> getSeatsByScreenRoom(Long screenRoomId) {
        return seatRepository.getSeatsByScreenRoom(screenRoomId);
    }

    @Override
    public double getSeatPriceById(Long seatId) {
        return seatRepository.getSeatPriceById(seatId);
    }

    @Override
    public List<Long> getBookedSeatsBySchedule(Long scheduleId) {
        return seatRepository.getBookedSeatsBySchedule(scheduleId);
    }
}
