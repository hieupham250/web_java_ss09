package com.example.ss09.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Schedule {
    private long id;
    private Long movieId;
    private String movieTitle;
    private Date showTime;
    private long screenRoomId;
    private int availableSeats;
    private String format;
}
