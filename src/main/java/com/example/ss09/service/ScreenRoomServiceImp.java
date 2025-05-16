package com.example.ss09.service;

import com.example.ss09.model.ScreenRoom;
import com.example.ss09.repository.ScreenRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenRoomServiceImp implements ScreenRoomService {
    @Autowired
    private ScreenRoomRepository screenRoomRepository;

    @Override
    public List<ScreenRoom> findAll() {
        return screenRoomRepository.findAll();
    }
}
