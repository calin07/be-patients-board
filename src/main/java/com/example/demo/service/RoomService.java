package com.example.demo.service;

import com.example.demo.dto.RoomDTO;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomDTO> getRooms() {
        List<RoomDTO> roomDTOList = new ArrayList<>();
        for (Room room : roomRepository.findAll())
            roomDTOList.add(new RoomDTO(room.getName(), room.getSpeciality().getId()));

        return roomDTOList;
    }
}
