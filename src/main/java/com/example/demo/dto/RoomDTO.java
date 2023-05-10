package com.example.demo.dto;

public class RoomDTO {

    private String name;
    private Long specialityId;

    public RoomDTO(String name, Long specialityId) {
        this.name = name;
        this.specialityId = specialityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }
}
