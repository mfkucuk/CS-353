package com.group18.backend.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.group18.backend.models.Room;
import com.group18.backend.models.RoomView;
import com.group18.backend.service.RoomService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("id={id}")
    public int insertRoom(@PathVariable("id") UUID id, @RequestBody Room room) {
        return roomService.insertRoom(id, room);
    }

    @GetMapping("/get/id={id}")
    public RoomView getRoomById(@PathVariable("id") UUID id) {
        return roomService.getRoomById(id).orElse(null);
    }

    @DeleteMapping("/id={id}")
    public int deleteRoomById(@PathVariable("id") UUID id) {
        return roomService.deleteRoomById(id);
    }
}
