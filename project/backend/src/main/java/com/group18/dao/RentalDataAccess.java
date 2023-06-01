package com.group18.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.convert.Jsr310Converters.DateToLocalDateConverter;
import org.springframework.data.convert.Jsr310Converters.DateToLocalDateTimeConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.misc.DataToLocalDateTime;
import com.group18.models.Rental;

import lombok.RequiredArgsConstructor;

@Repository("Rental") @Transactional
@RequiredArgsConstructor
public class RentalDataAccess implements RentalDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertRental(UUID id, Rental rental) {
        final String sql = "INSERT INTO Rental VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, ?)";

        return jdbcTemplate.update(sql, new Object[] { id, rental.getLocation(), rental.getAvailableStart(), rental.getAvailableEnd(),
                rental.getRestrictions(), rental.getType(), rental.getRating(), rental.getFeatures(), rental.getPrice(), rental.getHomeownerId() });
    }

    @Override
    public int updateRatingById(UUID rentalId, int newRating) {
        final String sql = "UPDATE Rental SET rating = ? WHERE rental_id = ?";

        return jdbcTemplate.update(sql, new Object[] { newRating, rentalId });
    }

    @Override
    public Optional<Rental> getRentalById(UUID rentalId) {
        final String sql = "";

        return null;
    }

    @Override
    public List<Rental> getAllRentals() {
        final String sql = "SELECT * FROM Rental";

        List<Rental> allRentals = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID rentalId = UUID.fromString(resultSet.getString("rental_id"));
            String location = resultSet.getString("location");
            LocalDateTime availableStart = DataToLocalDateTime.Convert(resultSet.getDate("available_start"));
            LocalDateTime availableEnd = DataToLocalDateTime.Convert(resultSet.getDate("available_end"));
            int restrictions = resultSet.getInt("restrictions");
            return new Rental(

            );
        });
    }
    
}
