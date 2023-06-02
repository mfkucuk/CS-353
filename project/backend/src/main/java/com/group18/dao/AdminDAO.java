package com.group18.dao;

import java.util.UUID;

import com.group18.models.Admin;

public interface AdminDAO {

    int insertAdmin(UUID id, Admin admin);
    default int insertAdmin(Admin admin) 
    {
        UUID id = UUID.randomUUID();
        return insertAdmin(id, admin);
    }    
}
