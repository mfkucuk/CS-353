package com.group18.backend.dao;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.models.Flat;
import com.group18.backend.models.FlatView;

import lombok.RequiredArgsConstructor;

@Repository("Flat") @Transactional
@RequiredArgsConstructor
public class FlatDataAccess implements FlatDAO 
{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertFlat(UUID id, Flat flat) 
    {
        final String sql = "INSERT INTO Flat VALUES(?, ?)";

        return jdbcTemplate.update(sql, new Object[] { id, flat.getRoomCount() });
    }
    
    @Override
    public Optional<FlatView> getFlatById(UUID id) 
    {
        final String sql = "SELECT * FROM FlatView WHERE rental_id = ?";

        FlatView flat = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
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
            int roomCount = resultSet.getInt("room_count");
            return new FlatView(
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
                homeownerId,
                roomCount
            );
        }, new Object[] { id });
        return Optional.ofNullable(flat);
    }

    @Override
    public int deleteFlatById(UUID id) {
        final String sql = "DELETE FROM Flat WHERE rental_id = ?";

        return jdbcTemplate.update(sql, new Object[] { id });
    }
}
