package com.group18.backend.dao;

import java.util.Optional;
import java.util.UUID;

import com.group18.backend.models.Room;
import com.group18.backend.models.RoomView;

public interface RoomDAO 
{
    int insertRoom(UUID id, Room room);

    Optional<RoomView> getRoomById(UUID id);

    int deleteRoomById(UUID id);
}
