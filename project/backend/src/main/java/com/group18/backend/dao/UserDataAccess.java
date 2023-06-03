package com.group18.backend.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.misc.DataToLocalDateTime;
import com.group18.backend.models.User;

import lombok.RequiredArgsConstructor;

@Repository("users") @Transactional
@RequiredArgsConstructor
public class UserDataAccess implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertUser(UUID id, User user) {
        final String sql = "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, new Object[] { id, user.getFullName(), user.getEmail(), user.getDob(), user.getTCK(),
                user.getPassword(), user.getPhoneNumber() });   
    }

    @Override
    public int changePasswordById(UUID id, String newPassword) {
        final String sql = "UPDATE users SET password = ? WHERE user_id = ?";

        return jdbcTemplate.update(sql, new Object[] { newPassword, id });
    }

    @Override
    public int changeEmailById(UUID id, String newEmail) {
        final String sql = "UPDATE users SET email = ? WHERE user_id = ?";

        return jdbcTemplate.update(sql, new Object[] { newEmail, id });
    }

    @Override
    public int changePhoneNumberById(UUID id, String newPhoneNumber) {
        final String sql = "UPDATE users SET email = ? WHERE user_id = ?";

        return jdbcTemplate.update(sql, new Object[] { newPhoneNumber, id });
    }
    
    @Override
    public Optional<User> getUserById(UUID id) {   
        final String sql = "SELECT * FROM users WHERE user_id = ?";

        User user = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            return new User(
                userId,
                fullName,
                email,
                dob,
                TCK,
                password,
                phoneNumber
            );
        }, new Object[] { id });
        return Optional.ofNullable(user);
    }
    
    @Override
    public Optional<User> getUserByEmail(String email) {   
        final String sql = "SELECT * FROM users WHERE email = ?";

        User user = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String userEmail = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            return new User(
                userId,
                fullName,
                userEmail,
                dob,
                TCK,
                password,
                phoneNumber
            );
        }, new Object[] { email });
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAllUsers() {
        final String sql = "SELECT * FROM users";

        List<User> allUsers = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            LocalDateTime dob = DataToLocalDateTime.Convert(resultSet.getDate("dob"));
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            return new User(
                userId,
                fullName,
                email,
                dob,
                TCK,
                password,
                phoneNumber
            );
        });
        return allUsers;
    }

    
}
