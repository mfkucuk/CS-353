package com.group18.backend.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.group18.backend.misc.FilterBody;
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

    int updateTravelerIdByRentalId(UUID rentalId, UUID travelerId);
    int updateRatingAndCommentsById(UUID rentalId, int newRating, String newComment);

    Optional<Rental> getRentalById(UUID rentalId);
    Optional<RentalList> getRentalsByTravelerId(UUID travelerId);

    List<Rental> getAllRentals();
    List<Rental> getAllHomeownerRentals(UUID id);
    List<Rental> getFilteredRentals(FilterBody filterBody);

    int deleteRentalById(UUID id);
}
