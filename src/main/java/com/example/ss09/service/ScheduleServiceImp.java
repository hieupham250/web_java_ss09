package com.example.ss09.service;

import com.example.ss09.model.Schedule;
import com.example.ss09.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImp implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> findAllScheduleByMovie(Long movieId) {
        return scheduleRepository.findAllScheduleByMovie(movieId);
    }
}
