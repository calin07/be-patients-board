package com.example.demo.repository;

import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findBySpeciality_IdIn(List<Long> specialityIds);
}
