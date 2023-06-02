package com.group18.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.models.QAndA;
import com.group18.service.QAndAService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/qanda")
@RequiredArgsConstructor
public class QAndAController 
{
    private final QAndAService qAndAService;

    @PostMapping
    public int insertQAndA(@RequestBody QAndA qAndA) 
    {
        return qAndAService.insertQAndA(qAndA);
    }
}