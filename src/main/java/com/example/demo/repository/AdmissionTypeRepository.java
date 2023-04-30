package com.example.demo.repository;

import com.example.demo.model.AdmissionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionTypeRepository extends JpaRepository<AdmissionType, Long> {
}
