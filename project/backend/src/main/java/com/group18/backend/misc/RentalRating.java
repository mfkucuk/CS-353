package com.group18.backend.misc;

import java.util.UUID;

import lombok.Data;

@Data
public class RentalRating 
{
    private UUID rentalId;
    private String location;
    private int rating;

    public RentalRating(
        UUID rentalId,
        String location,
        int rating
    )
    {
        this.rentalId = rentalId;
        this.location = location;
        this.rating = rating;
    }
}
