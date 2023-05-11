package com.example.demo.service;

import com.example.demo.dto.InsuranceStatusDTO;
import com.example.demo.model.InsuranceStatus;
import com.example.demo.repository.InsuranceStatusRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceStatusService {

    private final InsuranceStatusRepository insuranceStatusRepository;

    public InsuranceStatusService(InsuranceStatusRepository insuranceStatusRepository) {
        this.insuranceStatusRepository = insuranceStatusRepository;
    }

    public List<InsuranceStatusDTO> getInsuranceStatus() {
        List<InsuranceStatusDTO> insuranceStatusDTOList = new ArrayList<>();
        for(InsuranceStatus insuranceStatus : insuranceStatusRepository.findAll())
            insuranceStatusDTOList.add(new InsuranceStatusDTO(insuranceStatus.getStatus()));

        return insuranceStatusDTOList;
    }
}
