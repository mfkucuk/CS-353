package com.group18.models;

import java.util.UUID;

import lombok.Data;

@Data
public class Room {
    private UUID rentalId;
    private int capacity;

    public Room(UUID rentalId, int capacity) {
        this.rentalId = rentalId;
        this.capacity = capacity;
    }
}
