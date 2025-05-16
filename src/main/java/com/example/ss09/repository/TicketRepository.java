package com.example.ss09.repository;

public interface TicketRepository {
    void createTicket(Long customerId, Long scheduleId, Long seatId, Double totalMoney);
}
