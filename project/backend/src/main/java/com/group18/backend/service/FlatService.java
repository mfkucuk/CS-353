package com.group18.backend.service;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.FlatDAO;
import com.group18.backend.models.Flat;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlatService 
{
    private final FlatDAO flatDAO;

    public int insertFlat(Flat flat) 
    {
        return flatDAO.insertFlat(flat);
    }
}
