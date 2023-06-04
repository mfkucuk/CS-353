package com.group18.backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.QAndADAO;
import com.group18.backend.models.QAndA;

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

    public List<QAndA> getQuestionsByRentalId(UUID rentalId) 
    {
        return qAndADAO.getQuestionsByRentalId(rentalId);
    }
}
