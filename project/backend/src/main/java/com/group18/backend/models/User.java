package com.group18.backend.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class User 
{
    private UUID userId;
    private String fullName;
    private String email;
    private LocalDateTime dob;
    private String TCK;
    private String password;
    private String phoneNumber;

    public User(
        UUID userId,
        String fullName,
        String email,
        LocalDateTime dob,
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