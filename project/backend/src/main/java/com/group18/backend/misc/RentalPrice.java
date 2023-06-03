package com.group18.backend.misc;

import java.util.UUID;

import lombok.Data;

@Data
public class RentalPrice 
{
    private UUID rentalId;
    private String location;
    private float price;

    public RentalPrice(
        UUID rentalId,
        String location,
        float price
    )
    {
        this.rentalId = rentalId;
        this.location = location;
        this.price = price;
    }
}
