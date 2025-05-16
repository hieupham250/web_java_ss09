package com.example.ss09.controller;

import com.example.ss09.model.Schedule;
import com.example.ss09.model.ScreenRoom;
import com.example.ss09.service.ScheduleService;
import com.example.ss09.service.ScreenRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    private ScreenRoomService screenRoomService;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/screenrooms")
    public String showScreenRooms(Model model) {
        List<ScreenRoom> rooms = screenRoomService.findAll();
        model.addAttribute("rooms", rooms);
        return "screenroomList";
    }

    @GetMapping("/movies/{movieId}/schedules")
    public String showSchedulesByMovie(@PathVariable Long movieId, Model model) {
        List<Schedule> schedules = scheduleService.findAllScheduleByMovie(movieId);
        model.addAttribute("schedules", schedules);
        model.addAttribute("movieId", movieId);
        return "scheduleList";
    }
}
