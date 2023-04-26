package com.example.demo.repository;

import com.example.demo.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

    List<Speciality> findAllByFunction_Id(Long functionId);
}