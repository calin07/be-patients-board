package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="Insurance_Status")
public class InsuranceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status",length = 50)
    private String status;

    public InsuranceStatus() {
    }

    public InsuranceStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
