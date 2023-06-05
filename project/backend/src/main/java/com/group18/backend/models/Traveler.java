package com.group18.backend.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
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
        @JsonProperty("userId")UUID userId,
        @JsonProperty("writtenReviews")String writtenReviews,
        @JsonProperty("balance")Float balance
    )
    {
        this.userId = userId;
        this.writtenReviews = writtenReviews;
        this.balance = balance;
    }
}
