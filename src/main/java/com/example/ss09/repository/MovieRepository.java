package com.example.ss09.repository;

import com.example.ss09.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();
    Movie findById(long id);
}
