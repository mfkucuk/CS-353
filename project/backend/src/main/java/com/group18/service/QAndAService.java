package com.group18.service;

import org.springframework.stereotype.Service;

import com.group18.dao.QAndADAO;
import com.group18.models.QAndA;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QAndAService 
{
    private final QAndADAO qAndADAO;
    
    public int insertQAndA(QAndA qAndA) 
    {
        return qAndADAO.insertQAndA(qAndA);
    }
}
