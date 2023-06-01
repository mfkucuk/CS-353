package com.group18.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Traveler extends User {
    private String writtenReviews;
    private Float balance;

    public Traveler(
        UUID userId,
        String fullName,
        String email,
        LocalDateTime dob,
        String TCK,
        String password,
        String phoneNumber,
        String writtenReviews,
        Float balance
    )
    {
        super(userId, fullName, email, dob, TCK, password, phoneNumber);
        this.writtenReviews = writtenReviews;
        this.balance = balance;
    }
}
