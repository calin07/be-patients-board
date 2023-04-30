package com.example.demo.controller;

import com.example.demo.model.AdmissionType;
import com.example.demo.model.Function;
import com.example.demo.model.InsuranceStatus;
import com.example.demo.service.AdmissionTypeService;
import com.example.demo.service.InsuranceStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final AdmissionTypeService admissionTypeService;
    private final InsuranceStatusService insuranceStatusService;

    public PatientController(AdmissionTypeService admissionTypeService, InsuranceStatusService insuranceStatusService) {
        this.admissionTypeService = admissionTypeService;
        this.insuranceStatusService = insuranceStatusService;
    }

    @GetMapping("/typeOfAdmissions")
    public List<AdmissionType> getAdmissionTypes() {
        return admissionTypeService.getAdmissionTypes();
    }

    @GetMapping("/insuranceStatus")
    public List<InsuranceStatus> getInsuranceStatus() {
        return insuranceStatusService.getInsuranceStatus();
    }
}
