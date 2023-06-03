package com.group18.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.UserDAO;
import com.group18.backend.models.TravelerView;
import com.group18.backend.models.User;

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

    public Optional<User> getUserByEmail(String email) 
    {
        return userDAO.getUserByEmail(email);
    }

    public List<User> getAllUsers() 
    {
        return userDAO.getAllUsers();
    }

    public Optional<TravelerView> updateEmailById(UUID id, String email)
    {
        return userDAO.updateEmailById(id, email);
    }

    public Optional<TravelerView> updatePhoneById(UUID id, String password)
    {
        return userDAO.updatePhoneById(id, password);
    }

    public Optional<TravelerView> updatePasswordById(UUID id, String phone)
    {
        return userDAO.updatePasswordById(id, phone);
    }
}
