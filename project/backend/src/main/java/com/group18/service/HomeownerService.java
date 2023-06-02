package com.group18.service;

import org.springframework.stereotype.Service;

import com.group18.dao.HomeownerDAO;
import com.group18.models.Homeowner;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeownerService 
{
    private final HomeownerDAO homeownerDAO;

    public int insertHomeowner(Homeowner homeowner) 
    {
        return homeownerDAO.insertHomeowner(homeowner);
    }
}
