package com.group18.api;

import org.springframework.web.bind.annotation.*;

import com.group18.models.Flat;
import com.group18.service.FlatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/flat")
@RequiredArgsConstructor
public class FlatController {
    private final FlatService flatService;

    @PostMapping
    public int insertFlat(@RequestBody Flat flat) {
        return flatService.insertFlat(flat);
    }
}
