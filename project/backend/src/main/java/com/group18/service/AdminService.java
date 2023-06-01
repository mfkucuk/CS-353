package com.group18.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.dao.AdminDAO;
import com.group18.models.Admin;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService 
{
    private final AdminDAO adminDAO;

    public int insertAdmin(Admin admin) 
    {
        return adminDAO.insertAdmin(admin);
    }

    public Optional<Admin> getAdminById(UUID id) 
    {
        return adminDAO.getAdminById(id);
    }

    public Optional<Admin> getAdminByEmail(String email) 
    {
        return adminDAO.getAdminByEmail(email);
    }

    public List<Admin> getAllAdmins() 
    {
        return adminDAO.getAllAdmins();
    }
}
