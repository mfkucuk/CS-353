package com.group18.dao;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.models.Traveler;

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

}
