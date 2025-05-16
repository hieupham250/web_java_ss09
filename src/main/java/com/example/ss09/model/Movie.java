package com.example.ss09.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    private long id;
    private String title;
    private String director;
    private String genre;
    private String description;
    private int duration;
    private String language;
}
