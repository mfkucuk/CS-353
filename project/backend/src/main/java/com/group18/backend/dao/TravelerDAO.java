package com.group18.backend.dao;

import java.util.UUID;

import com.group18.backend.models.Traveler;

public interface TravelerDAO {

    int insertTraveler(UUID id, Traveler traveler);
}
