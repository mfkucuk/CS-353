package com.group18.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Homeowner extends Traveler {
    private String receivedReviews;
    private Float reputation;

    public Homeowner(
        UUID userId,
        String fullName,
        String email,
        LocalDateTime dob,
        String TCK,
        String password,
        String phoneNumber,
        String writtenReviews,
        Float balance,
        String receivedReviews,
        Float reputation
    )
    {
        super(userId, fullName, email, dob, TCK, password, phoneNumber, writtenReviews, balance);
        this.receivedReviews = receivedReviews;
        this.reputation = reputation;
    }
}
