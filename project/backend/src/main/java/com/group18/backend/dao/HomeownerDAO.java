package com.group18.backend.dao;

import java.util.UUID;

import com.group18.backend.models.Homeowner;

public interface HomeownerDAO {
    
    int insertHomeowner(UUID id, Homeowner homeowner);
}
