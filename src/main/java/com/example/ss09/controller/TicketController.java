package com.example.ss09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private SeatService seatService;

    @Autowired
    private TicketService ticketService;
}
