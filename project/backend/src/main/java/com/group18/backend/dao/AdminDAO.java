package com.group18.backend.dao;

import java.util.Optional;
import java.util.UUID;

import com.group18.backend.models.Admin;
import com.group18.backend.models.AdminView;

public interface AdminDAO {

    int insertAdmin(UUID id, Admin admin);
    default int insertAdmin(Admin admin) 
    {
        UUID id = UUID.randomUUID();
        return insertAdmin(id, admin);
    }    
    Optional<AdminView> getHomeownerById(UUID id);
}
