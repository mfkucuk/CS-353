package com.group18.backend.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group18.backend.misc.FilterBody;
import com.group18.backend.misc.RentalList;
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
    public UUID insertRental(@RequestBody Rental rental) {
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

    @GetMapping(path = "homeowner={id}")
    public List<Rental> getAllHomeownerRentals(@PathVariable("id") UUID homeownerId) {
        return rentalService.getAllHomeownerRentals(homeownerId);
    }

    @PostMapping(path = "filter")
    public List<Rental> getFilteredRentals(@RequestBody FilterBody filterBody) {
        return rentalService.getFilteredRentals(filterBody);
    }

    @PostMapping(path = "search")
    public List<Rental> searchRentalsByLocation(@RequestBody String location) {
        return rentalService.searchRentalsByLocation(location);
    }

    @GetMapping("/traveler={id}")
    public RentalList getRentalsByTravelerId(@PathVariable("id") UUID travelerId) {
        return rentalService.getRentalsByTravelerId(travelerId).orElse(null);
    }

    @PutMapping(path = "/id={id}/rating={newRating}/comment={newComment}")
    public int updateRatingById(@PathVariable("id") UUID id, @PathVariable("newRating") int newRating, @PathVariable("newComment") String newComment) {
        return rentalService.updateRatingAndCommentsById(id, newRating, newComment);
    }

    @PutMapping(path = "/id={rental_id}/traveler={id}")
    public int updateTravelerIdByRentalId(@PathVariable("rental_id") UUID rentalId, @PathVariable("id") UUID travelerId) {
        return rentalService.updateTravelerIdByRentalId(rentalId, travelerId);
    }

    @DeleteMapping(path = "/id={id}")
    public int deleteRentalById(@PathVariable("id") UUID rentalId) {
        return rentalService.deleteRentalById(rentalId);
    }
}
