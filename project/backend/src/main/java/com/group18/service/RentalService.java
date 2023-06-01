package com.group18.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.dao.RentalDAO;
import com.group18.models.Rental;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentalService 
{
    private final RentalDAO rentalDAO;
    
    public int insertRental(Rental rental) 
    {
        return rentalDAO.insertRental(rental);
    }

    public int updateRatingById(UUID id, int newRating) 
    {
        return rentalDAO.updateRatingById(id, newRating);
    }

    public Optional<Rental> getRentalById(UUID id) 
    {
        return rentalDAO.getRentalById(id);
    }

    public List<Rental> getAllRentals() 
    {
        return rentalDAO.getAllRentals();
    }
}
