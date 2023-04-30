package com.example.demo.service;

import com.example.demo.model.AdmissionType;
import com.example.demo.repository.AdmissionTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionTypeService {

    private final AdmissionTypeRepository admissionTypeRepository;

    public AdmissionTypeService(AdmissionTypeRepository admissionTypeRepository) {
        this.admissionTypeRepository = admissionTypeRepository;
    }

    public List<AdmissionType> getAdmissionTypes() {
        return admissionTypeRepository.findAll();
    }
}
