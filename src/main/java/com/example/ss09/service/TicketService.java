package com.example.ss09.service;

public interface TicketService {
    void createTicket(Long customerId, Long scheduleId, Long seatId, Double totalMoney);
}
