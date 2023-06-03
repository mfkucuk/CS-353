package com.group18.backend.dao;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.models.Admin;

import lombok.RequiredArgsConstructor;

@Repository("Admin") @Transactional
@RequiredArgsConstructor
public class AdminDataAccess implements AdminDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertAdmin(UUID id, Admin admin) {
        final String sql = "INSERT INTO Admin VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, new Object[] { id, admin.getPastReports() });
    }
    
}
