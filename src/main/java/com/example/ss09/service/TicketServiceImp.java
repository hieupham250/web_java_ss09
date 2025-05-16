package com.example.ss09.service;

import com.example.ss09.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImp implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void createTicket(Long customerId, Long scheduleId, Long seatId, Double totalMoney) {
        ticketRepository.createTicket(customerId, scheduleId, seatId, totalMoney);
    }
}
