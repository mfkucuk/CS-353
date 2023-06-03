package com.group18.backend.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.group18.backend.models.User;

public interface UserDAO 
{

    int insertUser(UUID id, User user);
    default int insertUser(User user) 
    {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    int changePasswordById(UUID id, String newPassword);
    int changeEmailById(UUID id, String newEmail);
    int changePhoneNumberById(UUID id, String newPhoneNumber);

    Optional<User> getUserById(UUID id);
    Optional<User> getUserByEmail(String email);
    List<User> getAllUsers();
}
