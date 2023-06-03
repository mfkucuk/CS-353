package com.group18.backend.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
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
        @JsonProperty("userId")UUID userId,
        @JsonProperty("received_reviews")String receivedReviews,
        @JsonProperty("reputation")Float reputation
    )
    {
        this.userId = userId;
        this.receivedReviews = receivedReviews;
        this.reputation = reputation;
    }
}
