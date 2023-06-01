package com.group18.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.misc.DataToLocalDateTime;
import com.group18.models.Homeowner;

import lombok.RequiredArgsConstructor;

@Repository("Homeowner") @Transactional
@RequiredArgsConstructor
public class HomeownerDataAccess implements HomeownerDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertHomeowner(UUID id, Homeowner traveler) {
        final String sql = "INSERT INTO Homeowner VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, new Object[] { id, traveler.getFullName(), traveler.getEmail(), traveler.getDob(), traveler.getTCK(),
                traveler.getPassword(), traveler.getPhoneNumber(), traveler.getWrittenReviews(), traveler.getBalance() });
    }

    @Override
    public Optional<Homeowner> getHomeownerById(UUID id) {
        final String sql = "SELECT * FROM Homeowner WHERE user_id = ?";

        Homeowner homeowner = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String writtenReviews = resultSet.getString("written_reviews");
            Float balance = resultSet.getFloat("balance");
            String receivedReviews = resultSet.getString("received_reviews");
            Float reputation = resultSet.getFloat("reputation");
            return new Homeowner(
                userId,
                fullName,
                email,
                dob,
                TCK,
                password,
                phoneNumber,
                writtenReviews,
                balance,
                receivedReviews,
                reputation
            );
        }, new Object[] { id });
        return Optional.ofNullable(homeowner);
    }

    @Override
    public Optional<Homeowner> getHomeownerByEmail(String email) {
        final String sql = "SELECT * FROM Homeowner WHERE email = ?";

        Homeowner homeowner = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String userEmail = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String writtenReviews = resultSet.getString("written_reviews");
            Float balance = resultSet.getFloat("balance");
            String receivedReviews = resultSet.getString("received_reviews");
            Float reputation = resultSet.getFloat("reputation");
            return new Homeowner(
                userId,
                fullName,
                userEmail,
                dob,
                TCK,
                password,
                phoneNumber,
                writtenReviews,
                balance,
                receivedReviews,
                reputation
            );
        }, new Object[] { email });
        return Optional.ofNullable(homeowner);
    }

    @Override
    public List<Homeowner> getAllHomeowners() {
        final String sql = "SELECT * FROM Homeowner";

        List<Homeowner> allUsers = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String writtenReviews = resultSet.getString("written_reviews");
            Float balance = resultSet.getFloat("balance");
            String receivedReviews = resultSet.getString("received_reviews");
            Float reputation = resultSet.getFloat("reputation");
            return new Homeowner(
                userId,
                fullName,
                email,
                dob,
                TCK,
                password,
                phoneNumber,
                writtenReviews,
                balance,
                receivedReviews,
                reputation
            );
        });
        return allUsers;
    
    }
    
}
