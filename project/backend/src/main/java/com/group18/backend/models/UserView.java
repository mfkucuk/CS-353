package com.group18.backend.models;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class UserView {
    
    private UUID userId;
    private String fullName;
    private String email;
    private LocalDate dob;
    private String TCK;
    private String password;
    private String phoneNumber;


    public UserView(
        UUID userId,
        String fullName,
        String email,
        LocalDate dob,
        String TCK,
        String password,
        String phoneNumber
    ) 
    {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.dob = dob;
        this.TCK = TCK;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
