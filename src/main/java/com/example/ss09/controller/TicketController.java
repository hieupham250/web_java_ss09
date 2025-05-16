package com.example.ss09.controller;

import com.example.ss09.model.Seat;
import com.example.ss09.service.SeatService;
import com.example.ss09.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private SeatService seatService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/booking")
    public String showBookingPage(@RequestParam Long scheduleId,
                                  @RequestParam Long screenRoomId,
                                  @RequestParam Long customerId,
                                  Model model) {
        List<Seat> seats = seatService.getSeatsByScreenRoom(screenRoomId);
        List<Long> bookedSeats = seatService.getBookedSeatsBySchedule(scheduleId);

        model.addAttribute("seats", seats);
        model.addAttribute("bookedSeats", bookedSeats);
        model.addAttribute("scheduleId", scheduleId);
        model.addAttribute("screenRoomId", screenRoomId);
        model.addAttribute("customerId", customerId);
        return "booking";
    }

    @PostMapping("/book")
    public String bookTicket(@RequestParam Long scheduleId,
                             @RequestParam Long screenRoomId,
                             @RequestParam Long seatId,
                             @RequestParam Long customerId,
                             Model model) {
        double seatPrice = seatService.getSeatPriceById(seatId);

        ticketService.createTicket(customerId, scheduleId, seatId, seatPrice);

        model.addAttribute("message", "Đặt vé thành công!");
        return "redirect:/tickets/booking?scheduleId=" + scheduleId +
                "&screenRoomId=" + screenRoomId +
                "&customerId=" + customerId;
    }

    @GetMapping("/book")
    public String handleGetBook(@RequestParam Long scheduleId,
                                @RequestParam Long screenRoomId,
                                @RequestParam Long customerId) {
        return "redirect:/tickets/booking?scheduleId=" + scheduleId +
                "&screenRoomId=" + screenRoomId +
                "&customerId=" + customerId;
    }
}
