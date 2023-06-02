package com.group18.service;

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
}
