package com.group18.backend.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Rental {
    private UUID rentalId;
    private String location;
    private LocalDateTime availableStart;
    private LocalDateTime availableEnd;
    private String restrictions;
    private String type;
    private int rating;
    private String[] features;
    private String[] comments;
    private float price;
    private UUID travelerId;
    private UUID homeownerId;

    public Rental(
        @JsonProperty("rentalId")UUID rentalId,
        @JsonProperty("location")String location,
        @JsonProperty("availableStart")LocalDateTime availableStart,
        @JsonProperty("availableEnd")LocalDateTime availableEnd,
        @JsonProperty("restrictions")String restrictions,
        @JsonProperty("type")String type,
        @JsonProperty("rating")int rating,
        @JsonProperty("features")String[] features,
        @JsonProperty("comments")String[] comments,
        @JsonProperty("price")float price,
        @JsonProperty("travelerId")UUID travelerId,
        @JsonProperty("homownerId")UUID homeownerId
    ) {
        this.rentalId = rentalId;
        this.location = location;
        this.availableStart = availableStart;
        this.availableEnd = availableEnd;
        this.restrictions = restrictions;
        this.type = type;
        this.rating = rating;
        this.features = features;
        this.comments = comments;
        this.price = price;
        this.travelerId = travelerId;
        this.homeownerId = homeownerId;
    }
}
