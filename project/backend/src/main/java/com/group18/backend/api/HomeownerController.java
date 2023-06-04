package com.group18.backend.api;

import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.backend.models.Homeowner;
import com.group18.backend.models.HomeownerView;
import com.group18.backend.models.TravelerView;
import com.group18.backend.service.HomeownerService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/homeowner")
@RequiredArgsConstructor
public class HomeownerController 
{
    private final HomeownerService homeownerService;

    @GetMapping(path = "id={id}")
    public HomeownerView getUserById(@PathVariable("id") UUID id) 
    {
        return homeownerService.getHomeownerById(id).orElse(null);
    }

    @PutMapping(path = "id={id}/balance={balance}")
    public Optional<HomeownerView> updateBalanceById(UUID id, Float balance)
    {
        return homeownerService.updateBalanceById(id, balance);
    } 
    
}

