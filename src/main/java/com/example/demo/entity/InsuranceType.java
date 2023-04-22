package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="InsuranceType")
public class InsuranceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
