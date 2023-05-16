package com.group18.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.group18.models.User;

public interface UserDAO 
{
    int insertUser(UUID id, User user);
    default int insertUser(User user) 
    {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    Optional<User> getUserById(UUID id);
    List<User> getAllUsers();
}
