package com.group18.dao;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.models.Homeowner;

import lombok.RequiredArgsConstructor;

@Repository("Homeowner") @Transactional
@RequiredArgsConstructor
public class HomeownerDataAccess implements HomeownerDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertHomeowner(UUID id, Homeowner homeowner) {
        final String sql = "INSERT INTO Homeowner VALUES(?, ?, ?)";

        return jdbcTemplate.update(sql, new Object[] { id, homeowner.getReceivedReviews(), homeowner.getReputation() });
    }
    
}
