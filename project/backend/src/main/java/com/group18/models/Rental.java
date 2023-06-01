package com.group18.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Rental {
    private UUID rentalId;
    private String location;
    private LocalDateTime availableStart;
    private LocalDateTime availableEnd;
    private int restrictions;
    private String type;
    private int rating;
    private String[] features;
    private float price;
    private UUID travelerId;
    private UUID homeownerId;

    public Rental(
        UUID rentalId,
        String location,
        LocalDateTime availableStart,
        LocalDateTime availableEnd,
        int restrictions,
        String type,
        int rating,
        String[] features,
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
        this.price = price;
        this.travelerId = travelerId;
        this.homeownerId = homeownerId;
    }
}