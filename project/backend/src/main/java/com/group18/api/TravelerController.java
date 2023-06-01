package com.group18.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path = "id={id}")
    public Traveler getTravelerById(@PathVariable("id") UUID id) 
    {
        return travelerService.getTravelerById(id).orElse(null);
    }

    @GetMapping(path = "email={email}")
    public Traveler getTravelerByEmail(@PathVariable("email") String email) 
    {
        return travelerService.getTravelerByEmail(email).orElse(null);
    }

    @GetMapping()
    public List<Traveler> getAllTravelers() 
    {
        return travelerService.getAllTravelers();
    }
}
