package com.example.ss09.service;

import com.example.ss09.model.Customer;
import com.example.ss09.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Customer login(String username, String password) {
        return loginRepository.login(username, password);
    }
}
