package com.group18.dao;

import java.util.UUID;

import com.group18.models.Room;

public interface RoomDAO 
{
    int insertRoom(UUID id, Room room);
    default int insertRoom(Room room) 
    {
        UUID id = UUID.randomUUID();
        return insertRoom(id, room);
    } 
}
