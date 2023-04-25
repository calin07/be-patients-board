package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Patient_Surgery_Details")
public class PatientSurgeryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="team_of_medics",length = 50)
    private String teamOfMedics;

    @Column(name="details",length = 50)
    private String details;

    @Column(name="date")
    private Date date;

    public PatientSurgeryDetails(String teamOfMedics, String details, Date date) {
        this.teamOfMedics = teamOfMedics;
        this.details = details;
        this.date = date;
    }

    public PatientSurgeryDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamOfMedics() {
        return teamOfMedics;
    }

    public void setTeamOfMedics(String teamOfMedics) {
        this.teamOfMedics = teamOfMedics;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
