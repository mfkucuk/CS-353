package com.group18.backend.dao;

import java.util.UUID;

import com.group18.backend.models.Homeowner;

public interface HomeownerDAO {
    
    int insertHomeowner(UUID id, Homeowner homeowner);
    default int insertHomeowner(Homeowner homeowner) 
    {
        UUID id = UUID.randomUUID();
        return insertHomeowner(id, homeowner);
    }
}
