package com.group18.backend.models;

import java.time.LocalDateTime;
import java.util.UUID;

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
        UUID rentalId,
        String location,
        LocalDateTime availableStart,
        LocalDateTime availableEnd,
        String restrictions,
        String type,
        int rating,
        String[] features,
        String[] comments,
        float price,
        UUID travelerId,
        UUID homeownerId
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
