package com.group18.backend.dao;

import java.util.Optional;
import java.util.UUID;

import com.group18.backend.models.Homeowner;
import com.group18.backend.models.HomeownerView;

public interface HomeownerDAO {
    
    int insertHomeowner(UUID id, Homeowner homeowner);
    Optional<HomeownerView> getHomeownerById(UUID id);
    Optional<HomeownerView> updateBalanceById(UUID id, Float balance);

    int increaseReputation(UUID id, Float newRep);
}
