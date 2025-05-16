package com.example.ss09.service;

import com.example.ss09.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(long id);
}
