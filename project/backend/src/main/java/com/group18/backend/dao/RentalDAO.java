package com.group18.backend.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.group18.backend.misc.RentalList;
import com.group18.backend.models.Rental;

public interface RentalDAO 
{
    UUID insertRental(UUID id, Rental rental);
    default UUID insertRental(Rental rental) 
    {
        UUID id = UUID.randomUUID();
        return insertRental(id, rental);
    }

    int updateRatingById(UUID rentalId, int newRating);
    int updateTravelerIdByRentalId(UUID rentalId, UUID travelerId);

    Optional<Rental> getRentalById(UUID rentalId);
    Optional<RentalList> getRentalsByTravelerId(UUID travelerId);

    List<Rental> getAllRentals();
}
