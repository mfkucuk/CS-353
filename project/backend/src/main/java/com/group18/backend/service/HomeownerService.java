package com.group18.backend.service;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.HomeownerDAO;
import com.group18.backend.models.Homeowner;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeownerService 
{
    private final HomeownerDAO homeownerDAO;

    
}
