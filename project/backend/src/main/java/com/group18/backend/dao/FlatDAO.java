package com.group18.backend.dao;

import java.util.Optional;
import java.util.UUID;

import com.group18.backend.models.Flat;
import com.group18.backend.models.FlatView;

public interface FlatDAO 
{
    int insertFlat(UUID id, Flat flat);

    Optional<FlatView> getFlatById(UUID id);

    int deleteFlatById(UUID id);
}
