package com.group18.backend.dao;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.models.Traveler;
import com.group18.backend.models.TravelerView;

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
    public Optional<TravelerView> getTravelerById(UUID id) {
        final String sql = "SELECT * FROM TravelerView WHERE user_id = ?";

        TravelerView travelerView = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String e_mail = resultSet.getString("e_mail");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String writtenReviews = resultSet.getString("written_reviews");
            Float balance = resultSet.getFloat("balance");
            boolean isAdmin = resultSet.getBoolean("is_admin");
            return new TravelerView(
                userId,
                fullName,
                e_mail,
                dob,
                TCK,
                password,
                phoneNumber,
                isAdmin,
                writtenReviews,
                balance
            );
        }, new Object[] { id });
        return Optional.ofNullable(travelerView);
    }

    @Override
    public Optional<TravelerView> updateBalanceById(UUID id, Float balance) {
        final String sql1 = "UPDATE traveler SET balance = ? WHERE user_id = ?";

        jdbcTemplate.update(sql1, new Object[] { balance, id });

        TravelerView traveler = getTravelerById(id).orElse(null);
        
        return Optional.ofNullable(traveler);
    }

    
}
