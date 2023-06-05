package com.group18.backend.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Flat {
    private UUID rentalId;
    private int roomCount;

    public Flat(@JsonProperty("rentalId") UUID rentalId, @JsonProperty("roomCount") int roomCount) {
        this.rentalId = rentalId;
        this.roomCount = roomCount;
    }
}
