package com.group18.backend.dao;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.models.Admin;
import com.group18.backend.models.AdminView;

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

    @Override
    public Optional<AdminView> getHomeownerById(UUID id)
    {
        final String sql = "SELECT * FROM AdminView WHERE user_id = ?";

        AdminView homeownerView = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String e_mail = resultSet.getString("e_mail");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            boolean isAdmin = resultSet.getBoolean("is_admin");
            String pastReports = resultSet.getString("past_reports");
            return new AdminView(
                userId,
                fullName,
                e_mail,
                dob,
                TCK,
                password,
                phoneNumber,
                isAdmin,
                pastReports
            );
        }, new Object[] { id });
        return Optional.ofNullable(homeownerView);
    }
    
}
