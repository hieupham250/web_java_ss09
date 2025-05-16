package com.example.ss09.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seat {
    private long id;
    private long screenRoomId;
    private Double price;
    private String status;
}
