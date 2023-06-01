package com.group18.models;

import java.util.UUID;

import lombok.Data;

@Data
public class Flat {
    private UUID rentalId;
    private int roomCount;

    public Flat(UUID rentalId, int roomCount) {
        this.rentalId = rentalId;
        this.roomCount = roomCount;
    }
}
