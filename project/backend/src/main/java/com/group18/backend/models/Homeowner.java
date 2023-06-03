package com.group18.backend.models;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Homeowner 
{
    private UUID userId;
    private String receivedReviews;
    private Float reputation;

    public Homeowner(
        UUID userId,
        String receivedReviews,
        Float reputation
    )
    {
        this.userId = userId;
        this.receivedReviews = receivedReviews;
        this.reputation = reputation;
    }
}
