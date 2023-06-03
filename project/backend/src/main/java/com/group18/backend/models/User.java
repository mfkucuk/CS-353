package com.group18.backend.models;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User 
{
    private UUID userId;
    private String fullName;
    private String email;
    private LocalDate dob;
    private String TCK;
    private String password;
    private String phoneNumber;


    public User(
        @JsonProperty("userId") UUID userId,
        @JsonProperty("fullName") String fullName,
        @JsonProperty("email") String email,
        @JsonProperty("dob") LocalDate dob,
        @JsonProperty("TCK") String TCK,
        @JsonProperty("password") String password,
        @JsonProperty("phoneNumber") String phoneNumber
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