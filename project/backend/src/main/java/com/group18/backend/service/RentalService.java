package com.group18.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.RentalDAO;
import com.group18.backend.misc.RentalList;
import com.group18.backend.models.Rental;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentalService 
{
    private final RentalDAO rentalDAO;
    
    public UUID insertRental(Rental rental) 
    {
        return rentalDAO.insertRental(rental);
    }

    public int updateRatingById(UUID id, int newRating) 
    {
        return rentalDAO.updateRatingById(id, newRating);
    }

    public int updateTravelerIdByRentalId(UUID rentalId, UUID travelerId) 
    {
        return rentalDAO.updateTravelerIdByRentalId(rentalId, travelerId);
    }

    public Optional<Rental> getRentalById(UUID id) 
    {
        return rentalDAO.getRentalById(id);
    }

    public Optional<RentalList> getRentalsByTravelerId(UUID travelerId) 
    {
        return rentalDAO.getRentalsByTravelerId(travelerId);
    }

    public List<Rental> getAllRentals() 
    {
        return rentalDAO.getAllRentals();
    }
}
