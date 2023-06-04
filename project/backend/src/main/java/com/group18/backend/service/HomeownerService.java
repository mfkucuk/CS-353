package com.group18.backend.service;

import java.util.UUID;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.HomeownerDAO;
import com.group18.backend.models.HomeownerView;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeownerService 
{
    private final HomeownerDAO homeownerDAO;

    public Optional<HomeownerView> getHomeownerById(UUID id) 
    {
        return homeownerDAO.getHomeownerById(id);
    }

    public Optional<HomeownerView> updateBalanceById(UUID id, Float balance) 
    {
        return homeownerDAO.updateBalanceById(id, balance);
    }
}
