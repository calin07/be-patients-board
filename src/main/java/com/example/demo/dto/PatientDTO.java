package com.example.demo.dto;

import com.example.demo.model.Speciality;

import java.util.Date;

public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialityName;
    private String roomNumber;
    private Date admissionDate;
    private Long specialityId;

    public PatientDTO(){};

    public PatientDTO(Long id, String firstName, String lastName, String specialityName, String roomNumber, Date admissionDate, Long specialityId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialityName = specialityName;
        this.roomNumber = roomNumber;
        this.admissionDate = admissionDate;
        this.specialityId = specialityId;
    }

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

}
