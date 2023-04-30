package com.example.demo.controller;

import com.example.demo.model.AdmissionType;
import com.example.demo.model.Function;
import com.example.demo.service.AdmissionTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final AdmissionTypeService admissionTypeService;

    public PatientController(AdmissionTypeService admissionTypeService) {
        this.admissionTypeService = admissionTypeService;
    }

    @GetMapping("/typeOfAdmissions")
    public List<AdmissionType> functions() {
        return admissionTypeService.getAdmissionTypes();
    }
}
