package com.group18.backend.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.group18.backend.models.Flat;
import com.group18.backend.models.FlatView;
import com.group18.backend.service.FlatService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/flat")
@RequiredArgsConstructor
public class FlatController {
    private final FlatService flatService;

    @PostMapping("id={id}")
    public int insertFlat(@PathVariable("id") UUID id, @RequestBody Flat flat) {
        return flatService.insertFlat(id, flat);
    }

    @GetMapping("/get/id={id}")
    public FlatView getFlatById(@PathVariable("id") UUID id) {
        return flatService.getFlatById(id).orElse(null);
    }

    @DeleteMapping(path = "/id={id}")
    public int deleteFlatById(@PathVariable("id") UUID id) {
        return flatService.deleteFlatById(id);
    }
}
