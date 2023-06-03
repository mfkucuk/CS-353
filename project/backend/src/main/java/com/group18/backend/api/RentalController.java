package com.group18.backend.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.backend.models.Rental;
import com.group18.backend.service.RentalService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/rental")
@RequiredArgsConstructor
public class RentalController {
    private final RentalService rentalService;

    @PostMapping
    public int insertRental(@RequestBody Rental rental) {
        return rentalService.insertRental(rental);
    }

    @GetMapping(path = "/id={id}")
    public Rental getRentalById(@PathVariable("id") UUID id) {
        return rentalService.getRentalById(id).orElse(null);
    }

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @PutMapping(path = "/id={id}/rating={newRating}")
    public int updateRatingById(@PathVariable("id") UUID id, @PathVariable("newRating") int newRating) {
        return rentalService.updateRatingById(id, newRating);
    }
}
