package com.group18.backend.api;

import org.springframework.web.bind.annotation.*;

import com.group18.backend.models.Room;
import com.group18.backend.service.RoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public int insertRoom(@RequestBody Room room) {
        return roomService.insertRoom(room);
    }
}
