package com.group18.backend.dao;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.models.Room;
import com.group18.backend.models.RoomView;

import lombok.RequiredArgsConstructor;

@Repository("Room") @Transactional
@RequiredArgsConstructor
public class RoomDataAccess implements RoomDAO 
{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertRoom(UUID id, Room room) 
    {
        final String sql = "INSERT INTO Room VALUES(?, ?)";

        return jdbcTemplate.update(sql, new Object[] { id, room.getCapacity() });
    }

    @Override
    public Optional<RoomView> getRoomById(UUID id) 
    {
        final String sql = "SELECT * FROM RoomView WHERE rental_id = ?";

        RoomView room = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
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
            int capacity = resultSet.getInt("capacity");
            return new RoomView(
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
                capacity
            );
        }, new Object[] { id });
        return Optional.ofNullable(room);
    }
    
}
