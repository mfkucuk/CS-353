package com.group18.backend.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.group18.backend.models.Rental;

public interface RentalDAO 
{
    int insertRental(UUID id, Rental rental);
    default int insertRental(Rental rental) 
    {
        UUID id = UUID.randomUUID();
        return insertRental(id, rental);
    }

    int updateRatingById(UUID rentalId, int newRating);

    Optional<Rental> getRentalById(UUID rentalId);
    List<Rental> getAllRentals();
}
