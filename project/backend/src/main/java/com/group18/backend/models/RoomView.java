package com.group18.backend.models;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoomView extends Rental {

    private final int capacity;

    public RoomView(
        UUID rentalId, 
        String location, 
        LocalDate availableStart, 
        LocalDate availableEnd,
        String restrictions, 
        String type, 
        int rating, 
        String[] features, 
        String[] comments, 
        float price,
        UUID travelerId, 
        UUID homeownerId,
        int capacity
    ) 
    {
        super(rentalId, location, availableStart, availableEnd, restrictions, type, rating, features, comments, price,
                travelerId, homeownerId);
        this.capacity = capacity;
    }
    
}
