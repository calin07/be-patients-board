package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="Diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="inital_diagnosis",length = 50)
    private String initalDiagnosis;

    @Column(name="seventy_two_hour_diagnosis",length = 50)
    private String seventyTwoHourDiagnosis;

    @Column(name="final_diagnosis",length = 50)
    private String finalDiagnosis;

    public Diagnosis() {
    }

    public Diagnosis(String initalDiagnosis, String seventyTwoHourDiagnosis, String finalDiagnosis) {
        this.initalDiagnosis = initalDiagnosis;
        this.seventyTwoHourDiagnosis = seventyTwoHourDiagnosis;
        this.finalDiagnosis = finalDiagnosis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitalDiagnosis() {
        return initalDiagnosis;
    }

    public void setInitalDiagnosis(String initalDiagnosis) {
        this.initalDiagnosis = initalDiagnosis;
    }

    public String getSeventyTwoHourDiagnosis() {
        return seventyTwoHourDiagnosis;
    }

    public void setSeventyTwoHourDiagnosis(String seventyTwoHourDiagnosis) {
        this.seventyTwoHourDiagnosis = seventyTwoHourDiagnosis;
    }

    public String getFinalDiagnosis() {
        return finalDiagnosis;
    }

    public void setFinalDiagnosis(String finalDiagnosis) {
        this.finalDiagnosis = finalDiagnosis;
    }
}
