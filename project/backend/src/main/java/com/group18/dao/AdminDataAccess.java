package com.group18.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.misc.DataToLocalDateTime;
import com.group18.models.Admin;

import lombok.RequiredArgsConstructor;

@Repository("Admin") @Transactional
@RequiredArgsConstructor
public class AdminDataAccess implements AdminDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertAdmin(UUID id, Admin admin) {
        final String sql = "INSERT INTO Admin VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, new Object[] { id, admin.getFullName(), admin.getEmail(), admin.getDob(), admin.getTCK(),
            admin.getPassword(), admin.getPhoneNumber(), admin.getPastReports() });
    }

    @Override
    public Optional<Admin> getAdminById(UUID id) {
        final String sql = "SELECT * FROM Admin WHERE user_id = ?";

        Admin admin = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String pastReports = resultSet.getString("past_reports");
            return new Admin(
                userId,
                fullName,
                email,
                dob,
                TCK,
                password,
                phoneNumber,
                pastReports
            );
        }, new Object[] { id });
        return Optional.ofNullable(admin);
    }

    @Override
    public Optional<Admin> getAdminByEmail(String email) {
        final String sql = "SELECT * FROM Admin WHERE email = ?";

        Admin admin = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String userEmail = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String pastReports = resultSet.getString("past_reports");
            return new Admin(
                userId,
                fullName,
                userEmail,
                dob,
                TCK,
                password,
                phoneNumber,
                pastReports
            );
        }, new Object[] { email });
        return Optional.ofNullable(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        final String sql = "SELECT * FROM Admin";

        List<Admin> allAdmins = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String pastReports = resultSet.getString("past_reports");
            return new Admin(
                userId,
                fullName,
                email,
                dob,
                TCK,
                password,
                phoneNumber,
                pastReports
            );
        });
        return allAdmins;
    
    }
    
}
