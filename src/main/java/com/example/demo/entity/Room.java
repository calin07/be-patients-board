package com.example.demo.entity;
import com.example.demo.model.Speciality;
import jakarta.persistence.*;
@Entity
@Table(name="Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name",length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name="speciality_id")
    private Speciality speciality;
    public Room() {
    }

    public Room(String name, Speciality speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
