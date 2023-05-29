package com.group18.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.dao.UserDAO;
import com.group18.models.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService 
{
    private final UserDAO userDAO;

    public int insertUser(User user) 
    {
        return userDAO.insertUser(user);
    }

    public Optional<User> getUserById(UUID id) 
    {
        return userDAO.getUserById(id);
    }

    public List<User> getAllUsers() 
    {
        return userDAO.getAllUsers();
    }
}
