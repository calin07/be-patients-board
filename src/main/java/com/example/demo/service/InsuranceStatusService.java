package com.example.demo.service;

import com.example.demo.model.InsuranceStatus;
import com.example.demo.repository.InsuranceStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceStatusService {

    private final InsuranceStatusRepository insuranceStatusRepository;

    public InsuranceStatusService(InsuranceStatusRepository insuranceStatusRepository) {
        this.insuranceStatusRepository = insuranceStatusRepository;
    }

    public List<InsuranceStatus> getInsuranceStatus() {
        return insuranceStatusRepository.findAll();
    }
}
