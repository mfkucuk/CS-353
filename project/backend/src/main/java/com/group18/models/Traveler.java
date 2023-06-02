package com.group18.models;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Traveler 
{
    private UUID userId;
    private String writtenReviews;
    private Float balance;

    public Traveler(
        UUID userId,
        String writtenReviews,
        Float balance
    )
    {
        this.userId = userId;
        this.writtenReviews = writtenReviews;
        this.balance = balance;
    }
}
