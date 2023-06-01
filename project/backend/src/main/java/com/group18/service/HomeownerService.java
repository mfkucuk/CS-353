package com.group18.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<Homeowner> getHomeownerById(UUID id) 
    {
        return homeownerDAO.getHomeownerById(id);
    }

    public Optional<Homeowner> getHomeownerByEmail(String email) 
    {
        return homeownerDAO.getHomeownerByEmail(email);
    }

    public List<Homeowner> getAllHomeowners() 
    {
        return homeownerDAO.getAllHomeowners();
    }
}
