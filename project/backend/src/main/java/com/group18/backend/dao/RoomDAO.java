package com.group18.backend.dao;

import java.util.UUID;

import com.group18.backend.models.Room;

public interface RoomDAO 
{
    int insertRoom(UUID id, Room room);
}
