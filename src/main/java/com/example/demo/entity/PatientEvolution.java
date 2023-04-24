package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="PatientEvolution")
public class PatientEvolution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="evolutionDescription",length = 50)
    private String evolutionDescription;

    @Column(name = "fromDate")
    private Date fromDate;

    @Column(name="toDate")
    private Date toDate;

    public PatientEvolution() {
    }

    public PatientEvolution(String evolutionDescription, Date fromDate, Date toDate) {
        this.evolutionDescription = evolutionDescription;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvolutionDescription() {
        return evolutionDescription;
    }

    public void setEvolutionDescription(String evolutionDescription) {
        this.evolutionDescription = evolutionDescription;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}