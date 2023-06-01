package com.group18.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.group18.models.Traveler;

public interface TravelerDAO {

    int insertTraveler(UUID id, Traveler traveler);
    default int insertTraveler(Traveler traveler) 
    {
        UUID id = UUID.randomUUID();
        return insertTraveler(id, traveler);
    }

    Optional<Traveler> getTravelerById(UUID id);
    Optional<Traveler> getTravelerByEmail(String email);
    List<Traveler> getAllTravelers();
}
