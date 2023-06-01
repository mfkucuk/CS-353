package com.group18.models;

import java.util.UUID;

import lombok.Data;

@Data
public class Room {
    private UUID rentalId;
    private String roomType;
    private int capacity;

    public Room(UUID rentalId, String roomType, int capacity) {
        this.rentalId = rentalId;
        this.roomType = roomType;
        this.capacity = capacity;
    }
}
