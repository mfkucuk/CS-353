package com.group18.backend.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.misc.RentalList;
import com.group18.backend.models.Rental;
import com.group18.backend.models.Traveler;
import com.group18.backend.models.User;

import lombok.RequiredArgsConstructor;

@Repository("Rental") @Transactional
@RequiredArgsConstructor
public class RentalDataAccess implements RentalDAO {

    private final JdbcTemplate jdbcTemplate;
    private final UserDataAccess userDataAccess;
    private final TravelerDataAccess travelerDataAccess;

    @Override
    public UUID insertRental(UUID id, Rental rental) {
        final String sql = "INSERT INTO Rental VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, ?)";

        jdbcTemplate.update(sql, new Object[] { id, rental.getLocation(), rental.getAvailableStart(), rental.getAvailableEnd(),
                rental.getRestrictions(), rental.getType(), rental.getRating(), rental.getFeatures(), rental.getComments(), rental.getPrice(), 
                rental.getHomeownerId() });
        return id;
    }

    @Override
    public int updateRatingAndCommentsById(UUID rentalId, int newRating, String newComment) {
        final String sql = "UPDATE Rental SET rating = ?, comments = ? WHERE rental_id = ?";

        Rental rental = getRentalById(rentalId).orElse(null);
        User commenterUser = userDataAccess.getUserById(rental.getTravelerId()).orElse(null);
        
        String[] comments = rental.getComments();
        String[] newComments = new String[comments.length+1];
        System.arraycopy(comments, 0, newComments, 0, comments.length);
        newComments[newComments.length-1] = commenterUser.getFullName() + ": " + newComment;
        
        return jdbcTemplate.update(sql, new Object[] { newRating, newComments, rentalId });
    }
    
    @Override
    public int updateTravelerIdByRentalId(UUID rentalId, UUID travelerId) {
        final String sql = "UPDATE Rental SET traveler_id = ? WHERE rental_id = ?";

        Rental rental = getRentalById(rentalId).orElse(null);
        Traveler traveler = travelerDataAccess.getTravelerByUserId(travelerId).orElse(null);
        Traveler homeowner = travelerDataAccess.getTravelerByUserId(rental.getHomeownerId()).orElse(null);

        travelerDataAccess.updateBalanceById(travelerId, traveler.getBalance() - rental.getPrice());
        travelerDataAccess.updateBalanceById(homeowner.getUserId(), homeowner.getBalance() + rental.getPrice());

        return jdbcTemplate.update(sql, new Object[] { travelerId, rentalId });
    }

    @Override
    public Optional<Rental> getRentalById(UUID id) {
        final String sql = "SELECT * FROM Rental WHERE rental_id = ?";

        Rental rental = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID rentalId = UUID.fromString(resultSet.getString("rental_id"));
            String location = resultSet.getString("location");
            LocalDate availableStart = resultSet.getDate("available_start").toLocalDate();
            LocalDate availableEnd = resultSet.getDate("available_end").toLocalDate();
            String restrictions = resultSet.getString("restrictions");
            String type = resultSet.getString("type");
            int rating = resultSet.getInt("rating");
            String[] features = (String[]) resultSet.getArray("features").getArray();
            String[] comments = (String[]) resultSet.getArray("comments").getArray();
            int price = resultSet.getInt("price");
            String travelerIdString = resultSet.getString("traveler_id");
            UUID travelerId = null;
            if (travelerIdString != null) {
                travelerId = UUID.fromString(travelerIdString);
            }
            UUID homeownerId = UUID.fromString(resultSet.getString("homeowner_id"));
            return new Rental(
                rentalId,
                location,
                availableStart,
                availableEnd,
                restrictions,
                type,
                rating,
                features,
                comments,
                price,
                travelerId,
                homeownerId
            );
        }, new Object[] { id });
        return Optional.ofNullable(rental);
    }
    
    @Override
    public Optional<RentalList> getRentalsByTravelerId(UUID id) {
        final String sql = "SELECT * FROM Rental WHERE traveler_id = ?";

        List<Rental> rentals = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID rentalId = UUID.fromString(resultSet.getString("rental_id"));
            String location = resultSet.getString("location");
            LocalDate availableStart = resultSet.getDate("available_start").toLocalDate();
            LocalDate availableEnd = resultSet.getDate("available_end").toLocalDate();
            String restrictions = resultSet.getString("restrictions");
            String type = resultSet.getString("type");
            int rating = resultSet.getInt("rating");
            String[] features = (String[]) resultSet.getArray("features").getArray();
            String[] comments = (String[]) resultSet.getArray("comments").getArray();
            int price = resultSet.getInt("price");
            String travelerIdString = resultSet.getString("traveler_id");
            UUID travelerId = null;
            if (travelerIdString != null) {
                travelerId = UUID.fromString(travelerIdString);
            }
            UUID homeownerId = UUID.fromString(resultSet.getString("homeowner_id"));
            return new Rental(
                rentalId,
                location,
                availableStart,
                availableEnd,
                restrictions,
                type,
                rating,
                features,
                comments,
                price,
                travelerId,
                homeownerId
            );
        }, new Object[] { id });

        List<Rental> previousAccomadations = new ArrayList<Rental>();
        List<Rental> currentAccomodations = new ArrayList<Rental>();

        for (Rental rental : rentals) {
            if (rental.getAvailableEnd().isBefore(LocalDate.now())) {
                previousAccomadations.add(rental);
            }
            else {
                currentAccomodations.add(rental);
            }
        }

        RentalList rentalList = new RentalList(previousAccomadations, currentAccomodations);
        return Optional.ofNullable(rentalList);
    }

    @Override
    public List<Rental> getAllRentals() {
        final String sql = "SELECT * FROM Rental";
        
        List<Rental> allRentals = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID rentalId = UUID.fromString(resultSet.getString("rental_id"));
            String location = resultSet.getString("location");
            LocalDate availableStart = resultSet.getDate("available_start").toLocalDate();
            LocalDate availableEnd = resultSet.getDate("available_end").toLocalDate();
            String restrictions = resultSet.getString("restrictions");
            String type = resultSet.getString("type");
            int rating = resultSet.getInt("rating");
            String[] features = (String[]) resultSet.getArray("features").getArray();
            String[] comments = (String[]) resultSet.getArray("comments").getArray();
            int price = resultSet.getInt("price");
            String travelerIdString = resultSet.getString("traveler_id");
            UUID travelerId = null;
            if (travelerIdString != null) {
                travelerId = UUID.fromString(travelerIdString);
            }
            UUID homeownerId = UUID.fromString(resultSet.getString("homeowner_id"));
            return new Rental(
                rentalId,
                location,
                availableStart,
                availableEnd,
                restrictions,
                type,
                rating,
                features,
                comments,
                price,
                travelerId,
                homeownerId
            );
        });

        List<Rental> filteredRentals = new ArrayList<>();

        for (Rental rental : allRentals) {
            if (rental.getTravelerId() == null && rental.getAvailableEnd().isBefore(LocalDate.now())) {
                filteredRentals.add(rental);
            }
        }

        return filteredRentals;
    }

    @Override
    public List<Rental> getAllHomeownerRentals(UUID id) {
        final String sql = "SELECT * FROM Rental";
        
        List<Rental> allRentals = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID rentalId = UUID.fromString(resultSet.getString("rental_id"));
            String location = resultSet.getString("location");
            LocalDate availableStart = resultSet.getDate("available_start").toLocalDate();
            LocalDate availableEnd = resultSet.getDate("available_end").toLocalDate();
            String restrictions = resultSet.getString("restrictions");
            String type = resultSet.getString("type");
            int rating = resultSet.getInt("rating");
            String[] features = (String[]) resultSet.getArray("features").getArray();
            String[] comments = (String[]) resultSet.getArray("comments").getArray();
            int price = resultSet.getInt("price");
            String travelerIdString = resultSet.getString("traveler_id");
            UUID travelerId = null;
            if (travelerIdString != null) {
                travelerId = UUID.fromString(travelerIdString);
            }
            UUID homeownerId = UUID.fromString(resultSet.getString("homeowner_id"));
            return new Rental(
                rentalId,
                location,
                availableStart,
                availableEnd,
                restrictions,
                type,
                rating,
                features,
                comments,
                price,
                travelerId,
                homeownerId
            );
        });

        List<Rental> homeownerRentals = new ArrayList<Rental>();

        for (Rental rental : allRentals) {
            if (rental.getHomeownerId().equals(id)) {
                homeownerRentals.add(rental);
            }
        }

        return homeownerRentals;
    }


    
}
