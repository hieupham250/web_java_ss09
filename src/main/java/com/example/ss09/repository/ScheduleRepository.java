package com.example.ss09.repository;

import com.example.ss09.model.Schedule;

import java.util.List;

public interface ScheduleRepository {
    List<Schedule> findAllScheduleByMovie(Long movieId);
}
