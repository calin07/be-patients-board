package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Patient_Evolution")
public class PatientEvolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="evolution_description",length = 50)
    private String evolutionDescription;

    @Column(name = "from_date", columnDefinition = "DATE")
    private Date fromDate;

    @Column(name="to_date", columnDefinition = "DATE")
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
