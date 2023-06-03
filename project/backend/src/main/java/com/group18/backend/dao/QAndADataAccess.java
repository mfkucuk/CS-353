package com.group18.backend.dao;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group18.backend.models.QAndA;

import lombok.RequiredArgsConstructor;

@Repository("QAndA") @Transactional
@RequiredArgsConstructor
public class QAndADataAccess implements QAndADAO {

    @Override
    public int insertQAndA(UUID id, QAndA qAndA) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertQAndA'");
    }
    
}
