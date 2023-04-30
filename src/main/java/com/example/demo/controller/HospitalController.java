package com.example.demo.controller;

import com.example.demo.model.Room;
import com.example.demo.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    private final RoomService roomService;

    public HospitalController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    private List<Room> getRooms() {
        return roomService.getRooms();
    }
}
