package com.group18.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.models.Homeowner;
import com.group18.service.HomeownerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/homeowner")
@RequiredArgsConstructor
public class HomeownerController 
{
    private final HomeownerService homeownerService;

    @PostMapping
    public int insertHomeowner(@RequestBody Homeowner homeowner) 
    {
        return homeownerService.insertHomeowner(homeowner);
    }

    @GetMapping(path = "id={id}")
    public Homeowner getUserById(@PathVariable("id") UUID id) 
    {
        return homeownerService.getHomeownerById(id).orElse(null);
    }

    @GetMapping(path = "email={email}")
    public Homeowner getHomeownerByEmail(@PathVariable("email") String email) 
    {
        return homeownerService.getHomeownerByEmail(email).orElse(null);
    }

    @GetMapping()
    public List<Homeowner> getAllHomeowners() 
    {
        return homeownerService.getAllHomeowners();
    }
}

