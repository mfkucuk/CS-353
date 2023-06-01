package com.group18.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.misc.DataToLocalDateTime;
import com.group18.models.Traveler;

import lombok.RequiredArgsConstructor;

@Repository("Traveler") @Transactional
@RequiredArgsConstructor
public class TravelerDataAccess implements TravelerDAO{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertTraveler(UUID id, Traveler traveler) {
        final String sql = "INSERT INTO Traveler VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, new Object[] { id, traveler.getFullName(), traveler.getEmail(), traveler.getDob(), traveler.getTCK(),
                traveler.getPassword(), traveler.getPhoneNumber(), traveler.getWrittenReviews(), traveler.getBalance() });
    }

    @Override
    public Optional<Traveler> getTravelerById(UUID id) {
        final String sql = "SELECT * FROM Traveler WHERE user_id = ?";

        Traveler traveler = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String writtenReviews = resultSet.getString("written_reviews");
            Float balance = resultSet.getFloat("balance");
            return new Traveler(
                userId,
                fullName,
                email,
                dob,
                TCK,
                password,
                phoneNumber,
                writtenReviews,
                balance
            );
        }, new Object[] { id });
        return Optional.ofNullable(traveler);
    }

    @Override
    public Optional<Traveler> getTravelerByEmail(String email) {
        final String sql = "SELECT * FROM Traveler WHERE email = ?";

        Traveler traveler = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String userEmail = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String writtenReviews = resultSet.getString("written_reviews");
            Float balance = resultSet.getFloat("balance");
            return new Traveler(
                userId,
                fullName,
                userEmail,
                dob,
                TCK,
                password,
                phoneNumber,
                writtenReviews,
                balance
            );
        }, new Object[] { email });
        return Optional.ofNullable(traveler);
    }

    @Override
    public List<Traveler> getAllTravelers() {
        final String sql = "SELECT * FROM Traveler";

        List<Traveler> allUsers = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String writtenReviews = resultSet.getString("written_reviews");
            Float balance = resultSet.getFloat("balance");
            return new Traveler(
                userId,
                fullName,
                email,
                dob,
                TCK,
                password,
                phoneNumber,
                writtenReviews,
                balance
            );
        });
        return allUsers;
    
    }
    
}
