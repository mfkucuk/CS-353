package com.group18.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.models.Traveler;
import com.group18.service.TravelerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/traveler")
@RequiredArgsConstructor
public class TravelerController 
{
    private final TravelerService travelerService;

    @PostMapping
    public int insertTraveler(@RequestBody Traveler traveler) 
    {
        return travelerService.insertTraveler(traveler);
    }
}
