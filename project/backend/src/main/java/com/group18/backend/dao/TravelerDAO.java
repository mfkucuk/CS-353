package com.group18.backend.dao;

import java.util.Optional;
import java.util.UUID;

import com.group18.backend.models.Traveler;
import com.group18.backend.models.TravelerView;

public interface TravelerDAO {

    int insertTraveler(UUID id, Traveler traveler);

    Optional<TravelerView> getTravelerById(UUID id);
    Optional<TravelerView> updateBalanceById(UUID id, Float balance);
}
