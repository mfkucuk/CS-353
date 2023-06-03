package com.group18.backend.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.models.Traveler;

import lombok.RequiredArgsConstructor;

@Repository("Traveler") @Transactional
@RequiredArgsConstructor
public class TravelerDataAccess implements TravelerDAO{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertTraveler(UUID id, Traveler traveler) {
        final String sql = "INSERT INTO Traveler VALUES(?, ?, ?)";

        return jdbcTemplate.update(sql, new Object[] { id, traveler.getWrittenReviews(), traveler.getBalance() });
    }

    @Override
    public Optional<Traveler> getTravelerById(UUID id) {
        final String sql = "SELECT * FROM TravelerView WHERE user_id = ?";

        TravelerView traveler = jdbcTemplate.queryForObject(sql, (resultSet))
    }

    
}
