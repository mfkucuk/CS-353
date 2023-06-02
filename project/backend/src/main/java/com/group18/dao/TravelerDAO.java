package com.group18.dao;

import java.util.UUID;

import com.group18.models.Traveler;

public interface TravelerDAO {

    int insertTraveler(UUID id, Traveler traveler);
    default int insertTraveler(Traveler traveler) 
    {
        UUID id = UUID.randomUUID();
        return insertTraveler(id, traveler);
    }
}
