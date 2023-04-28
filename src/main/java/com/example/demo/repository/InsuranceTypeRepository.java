package com.example.demo.repository;

import com.example.demo.model.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceTypeRepository extends JpaRepository<InsuranceType,Long> {
}
