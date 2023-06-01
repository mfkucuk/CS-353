package com.group18.service;

import org.springframework.stereotype.Service;

import com.group18.dao.FlatDAO;
import com.group18.models.Flat;

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
