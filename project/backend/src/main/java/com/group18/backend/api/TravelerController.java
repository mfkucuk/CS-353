package com.group18.backend.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.backend.models.TravelerView;
import com.group18.backend.service.TravelerService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/traveler")
@RequiredArgsConstructor
public class TravelerController 
{
    private final TravelerService travelerService;

    @GetMapping(path = "id={id}")
    public TravelerView getUserById(@PathVariable("id") UUID id) 
    {
        return travelerService.getTravelerById(id).orElse(null);
    }
}
