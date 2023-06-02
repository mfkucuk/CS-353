package com.group18.dao;

import java.util.UUID;

import com.group18.models.QAndA;

public interface QAndADAO 
{
    int insertQAndA(UUID id, QAndA qAndA);
    default int insertQAndA(QAndA qAndA) 
    {
        UUID id = UUID.randomUUID();
        return insertQAndA(id, qAndA);
    }    
}
