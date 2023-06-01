package com.group18.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.dao.TravelerDAO;
import com.group18.models.Traveler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelerService 
{
    private final TravelerDAO travelerDAO;

    public int insertTraveler(Traveler traveler) 
    {
        return travelerDAO.insertTraveler(traveler);
    }

    public Optional<Traveler> getTravelerById(UUID id) 
    {
        return travelerDAO.getTravelerById(id);
    }

    public Optional<Traveler> getTravelerByEmail(String email) 
    {
        return travelerDAO.getTravelerByEmail(email);
    }

    public List<Traveler> getAllTravelers() 
    {
        return travelerDAO.getAllTravelers();
    }
}
