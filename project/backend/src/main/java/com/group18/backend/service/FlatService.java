package com.group18.backend.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.FlatDAO;
import com.group18.backend.models.Flat;
import com.group18.backend.models.FlatView;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlatService 
{
    private final FlatDAO flatDAO;

    public int insertFlat(UUID id, Flat flat) 
    {
        return flatDAO.insertFlat(id, flat);
    }

    public Optional<FlatView> getFlatById(UUID id) 
    {
        return flatDAO.getFlatById(id);
    }

    public int deleteFlatById(UUID id) 
    {
        return flatDAO.deleteFlatById(id);
    }
}
