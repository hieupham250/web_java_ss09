package com.example.ss09.controller;

import com.example.ss09.model.Movie;
import com.example.ss09.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private MovieService movieService;

    @GetMapping("home")
    public String findAll(Model model) {
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies", movies);
        return "home";
    }

    @GetMapping("detailMovie/{id}")
    public String detailMovie(Model model, @PathVariable long id) {
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movie);
        return "detailMovie";
    }
}
