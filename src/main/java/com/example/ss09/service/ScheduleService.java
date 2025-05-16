package com.example.ss09.service;

import com.example.ss09.model.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAllScheduleByMovie(Long movieId);
}
