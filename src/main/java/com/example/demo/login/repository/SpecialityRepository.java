package com.example.demo.login.repository;

import com.example.demo.login.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
}