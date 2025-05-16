package com.example.ss09.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    private long id;
    private long customerId;
    private long scheduleId;
    private List<Seat> listSeat;
    private double totalMoney;
    private Date created_at;
}
