package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="Insurance_Type")
public class InsuranceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="type",length = 50)
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InsuranceType(String type) {
        this.type = type;
    }

    public InsuranceType() {
    }
}
