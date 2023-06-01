package com.group18.service;

import org.springframework.stereotype.Service;

import com.group18.dao.RoomDAO;
import com.group18.models.Room;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService 
{
    private final RoomDAO roomDAO;

    public int insertRoom(Room Room) 
    {
        return roomDAO.insertRoom(Room);
    }
}
