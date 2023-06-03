package com.group18.backend.service;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.TravelerDAO;
import com.group18.backend.models.Traveler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelerService 
{
    private final TravelerDAO travelerDAO;

    public Optional<TravelerView> getUserById(UUID id) 
    {
        return userDAO.getUserById(id);
    }
}
