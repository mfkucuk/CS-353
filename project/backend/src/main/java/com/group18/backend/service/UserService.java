package com.group18.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.UserDAO;
import com.group18.backend.models.HomeownerView;
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

    public Optional<TravelerView> updateEmailByIdT(UUID id, String email)
    {
        return userDAO.updateEmailByIdT(id, email);
    }

    public Optional<TravelerView> updatePhoneByIdT(UUID id, String password)
    {
        return userDAO.updatePhoneByIdT(id, password);
    }

    public Optional<TravelerView> updatePasswordByIdT(UUID id, String phone)
    {
        return userDAO.updatePasswordByIdT(id, phone);
    }

    public Optional<HomeownerView> updateEmailByIdH(UUID id, String email)
    {
        return userDAO.updateEmailByIdH(id, email);
    }

    public Optional<HomeownerView> updatePhoneByIdH(UUID id, String password)
    {
        return userDAO.updatePhoneByIdH(id, password);
    }

    public Optional<HomeownerView> updatePasswordByIdH(UUID id, String phone)
    {
        return userDAO.updatePasswordByIdH(id, phone);
    }
}
