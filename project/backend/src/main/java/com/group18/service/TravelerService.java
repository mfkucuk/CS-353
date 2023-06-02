package com.group18.service;

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
}
