package com.example.ss09.repository;

import com.example.ss09.model.Customer;

public interface LoginRepository {
    public Customer login(String username, String password);
}
