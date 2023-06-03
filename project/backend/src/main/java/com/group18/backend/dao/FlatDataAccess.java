package com.group18.backend.dao;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.models.Flat;

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
    
}
