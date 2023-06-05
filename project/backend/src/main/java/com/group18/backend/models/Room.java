package com.group18.backend.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Room {
    private UUID rentalId;
    private int capacity;

    public Room(@JsonProperty("rentalId")UUID rentalId, @JsonProperty("capacity")int capacity) {
        this.rentalId = rentalId;
        this.capacity = capacity;
    }
}
