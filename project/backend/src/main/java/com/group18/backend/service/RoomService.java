package com.group18.backend.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.RoomDAO;
import com.group18.backend.models.Room;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService 
{
    private final RoomDAO roomDAO;

    public int insertRoom(UUID id, Room Room) 
    {
        return roomDAO.insertRoom(id, Room);
    }
}
