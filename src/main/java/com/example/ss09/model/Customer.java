package com.example.ss09.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    private Long id;
    private String username;
    private String phone;
    private String address;
    private String gender;
    private String email;
    private String password;
}
