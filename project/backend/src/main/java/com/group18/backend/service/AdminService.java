package com.group18.backend.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.AdminDAO;
import com.group18.backend.models.Admin;
import com.group18.backend.models.AdminView;

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

    public Optional<AdminView> getAdminByID(UUID id) 
    {
        return adminDAO.getAdminById(id);
    }
}
