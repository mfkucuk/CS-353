package com.group18.api;

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

}

