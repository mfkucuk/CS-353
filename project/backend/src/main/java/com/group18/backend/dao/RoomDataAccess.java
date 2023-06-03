package com.group18.backend.dao;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.models.Room;

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
    
}
