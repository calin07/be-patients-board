package com.example.demo.repository;

import com.example.demo.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
}