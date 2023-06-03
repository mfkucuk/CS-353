package com.group18.backend.dao;

import java.util.UUID;

import com.group18.backend.models.Flat;

public interface FlatDAO 
{
    int insertFlat(UUID id, Flat flat);
    default int insertFlat(Flat flat) 
    {
        UUID id = UUID.randomUUID();
        return insertFlat(id, flat);
    }
}