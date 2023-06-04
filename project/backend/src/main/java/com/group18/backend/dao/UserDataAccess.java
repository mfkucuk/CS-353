package com.group18.backend.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.models.Homeowner;
import com.group18.backend.models.HomeownerView;
import com.group18.backend.models.Traveler;
import com.group18.backend.models.TravelerView;
import com.group18.backend.models.User;

import lombok.RequiredArgsConstructor;

@Repository("users") @Transactional
@RequiredArgsConstructor
public class UserDataAccess implements UserDAO {

    private final JdbcTemplate jdbcTemplate;
    private final TravelerDataAccess travelerDataAccess;
    private final HomeownerDataAccess homeownerDataAccess;

    @Override
    public int insertUser(UUID id, User user) {
        final String sql = "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        int res = jdbcTemplate.update(sql, new Object[] { id, user.getFullName(), user.getEmail(), user.getDob(), user.getTCK(),
            user.getPassword(), user.getPhoneNumber(), false });   

        travelerDataAccess.insertTraveler(id, new Traveler(null, "", 0f));
        homeownerDataAccess.insertHomeowner(id, new Homeowner(null, "", 0f));

        return res;
    }

    @Override
    public int changePasswordById(UUID id, String newPassword) {
        final String sql = "UPDATE users SET password = ? WHERE user_id = ?";

        return jdbcTemplate.update(sql, new Object[] { newPassword, id });
    }

    @Override
    public int changeEmailById(UUID id, String newEmail) {
        final String sql = "UPDATE users SET e_mail = ? WHERE user_id = ?";

        return jdbcTemplate.update(sql, new Object[] { newEmail, id });
    }

    @Override
    public int changePhoneNumberById(UUID id, String newPhoneNumber) {
        final String sql = "UPDATE users SET e_mail = ? WHERE user_id = ?";

        return jdbcTemplate.update(sql, new Object[] { newPhoneNumber, id });
    }
    
    @Override
    public Optional<User> getUserById(UUID id) {   
        final String sql = "SELECT * FROM users WHERE user_id = ?";

        User user = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String e_mail = resultSet.getString("e_mail");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            boolean isAdmin = resultSet.getBoolean("is_admin");
            return new User(
                userId,
                fullName,
                e_mail,
                dob,
                TCK,
                password,
                phoneNumber,
                isAdmin
            );
        }, new Object[] { id });
        return Optional.ofNullable(user);
    }
    
    @Override
    public Optional<User> getUserByEmail(String e_mail) {   
        final String sql = "SELECT * FROM users WHERE e_mail = ?";

        List<User> users = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String userEmail = resultSet.getString("e_mail");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            boolean isAdmin = resultSet.getBoolean("is_admin");
            return new User(
                userId,
                fullName,
                userEmail,
                dob,
                TCK,
                password,
                phoneNumber,
                isAdmin
            );
        }, new Object[] { e_mail });

        if (users.size() == 1) {
            return Optional.ofNullable(users.get(0));
        }
        else {
            return Optional.ofNullable(null);
        }
    }

    @Override
    public List<User> getAllUsers() {
        final String sql = "SELECT * FROM users";

        List<User> allUsers = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            String fullName = resultSet.getString("full_name");
            String e_mail = resultSet.getString("e_mail");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            String TCK = resultSet.getString("TCK");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            boolean isAdmin = resultSet.getBoolean("is_admin");
            return new User(
                userId,
                fullName,
                e_mail,
                dob,
                TCK,
                password,
                phoneNumber,
                isAdmin
            );
        });
        return allUsers;
    }

    @Override
    public Optional<TravelerView> updateEmailByIdT(UUID id, String email)
    {
        final String sql = "UPDATE users SET e_mail = ? WHERE user_id = ?";

        jdbcTemplate.update(sql, new Object[] { email, id });

        return travelerDataAccess.getTravelerById(id);
    }

    @Override
    public Optional<TravelerView> updatePhoneByIdT(UUID id, String phone)
    {
        final String sql = "UPDATE users SET phone_number = ? WHERE user_id = ?";

        jdbcTemplate.update(sql, new Object[] { phone, id });

        return travelerDataAccess.getTravelerById(id);
    }

    @Override
    public Optional<TravelerView> updatePasswordByIdT(UUID id, String password)
    {
        final String sql = "UPDATE users SET password = ? WHERE user_id = ?";

        jdbcTemplate.update(sql, new Object[] { password, id });

        return travelerDataAccess.getTravelerById(id);
    }

    @Override
    public Optional<HomeownerView> updateEmailByIdH(UUID id, String email)
    {
        final String sql = "UPDATE users SET e_mail = ? WHERE user_id = ?";

        jdbcTemplate.update(sql, new Object[] { email, id });

        return homeownerDataAccess.getHomeownerById(id);
    }

    @Override
    public Optional<HomeownerView> updatePhoneByIdH(UUID id, String phone)
    {
        final String sql = "UPDATE users SET phone_number = ? WHERE user_id = ?";

        jdbcTemplate.update(sql, new Object[] { phone, id });

        return homeownerDataAccess.getHomeownerById(id);
    }

    @Override
    public Optional<HomeownerView> updatePasswordByIdH(UUID id, String password)
    {
        final String sql = "UPDATE users SET password = ? WHERE user_id = ?";

        jdbcTemplate.update(sql, new Object[] { password, id });

        return homeownerDataAccess.getHomeownerById(id);
    }
    
}
