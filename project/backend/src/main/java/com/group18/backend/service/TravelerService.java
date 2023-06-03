package com.group18.backend.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.TravelerDAO;
import com.group18.backend.models.TravelerView;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelerService 
{
    private final TravelerDAO travelerDAO;

    public Optional<TravelerView> getTravelerById(UUID id) 
    {
        return travelerDAO.getTravelerById(id);
    }
}
