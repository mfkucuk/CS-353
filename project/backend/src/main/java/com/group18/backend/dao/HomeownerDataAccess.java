package com.group18.backend.dao;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.models.Homeowner;
import com.group18.backend.models.HomeownerView;

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

    @Override
    public Optional<HomeownerView> getHomeownerById(UUID id) {
        final String sql = "SELECT * FROM HomeownerView WHERE user_id = ?";

        HomeownerView homeownerView = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String e_mail = resultSet.getString("e_mail");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String writtenReviews = resultSet.getString("written_reviews");
            Float balance = resultSet.getFloat("balance");
            String receivedReviews = resultSet.getString("received_reviews");
            Float reputation = resultSet.getFloat("reputation");
            boolean isAdmin = resultSet.getBoolean("is_admin");
            return new HomeownerView(
                userId,
                fullName,
                e_mail,
                dob,
                TCK,
                password,
                phoneNumber,
                isAdmin,
                writtenReviews,
                balance,
                receivedReviews,
                reputation
            );
        }, new Object[] { id });
        return Optional.ofNullable(homeownerView);
    }

    @Override
    public Optional<HomeownerView> updateBalanceById(UUID id, Float balance) {
        final String sql = "UPDATE traveler SET balance = ? WHERE user_id = ?";

        jdbcTemplate.update(sql, new Object[] { balance, id });

        HomeownerView homeowner = getHomeownerById(id).orElse(null);

        
        return Optional.ofNullable(homeowner);
    }

    @Override
    public int increaseReputation(UUID id, Float newRep) {
        final String sql = "UPDATE Homeowner SET reputation = ? WHERE user_id = ?";

        return jdbcTemplate.update(sql, new Object[] { newRep, id });
    }
    
}
