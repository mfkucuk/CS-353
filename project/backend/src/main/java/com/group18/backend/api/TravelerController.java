package com.group18.backend.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.backend.models.Traveler;
import com.group18.backend.service.TravelerService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
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
