package com.group18.backend.models;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TravelerView extends User {
    
    private UUID userId;
    private String writtenReviews;
    private Float balance;

    public TravelerView(
        UUID userId,
        String fullName,
        String email,
        LocalDate dob,
        String TCK,
        String password,
        String phoneNumber,
        String writtenReviews,
        Float balance
    )
    {
        super(userId, fullName, email, dob, TCK, password, phoneNumber);
        this.userId = userId;
        this.writtenReviews = writtenReviews;
        this.balance = balance;
    }
}
