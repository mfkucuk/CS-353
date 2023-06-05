package com.group18.backend.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.group18.backend.dao.RoomDAO;
import com.group18.backend.models.Room;
import com.group18.backend.models.RoomView;

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

    public Optional<RoomView> getRoomById(UUID id) 
    {
        return roomDAO.getRoomById(id);
    }

    public int deleteRoomById(UUID id) 
    {
        return roomDAO.deleteRoomById(id);
    }
}
