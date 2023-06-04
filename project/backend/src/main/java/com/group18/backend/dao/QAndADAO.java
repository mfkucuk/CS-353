package com.group18.backend.dao;

import java.util.List;
import java.util.UUID;

import com.group18.backend.models.QAndA;

public interface QAndADAO 
{
    int insertQAndA(QAndA qAndA);

    List<QAndA> getQuestionsByRentalId(UUID rentalId);

    int addAnswer(QAndA qAndA);
}
