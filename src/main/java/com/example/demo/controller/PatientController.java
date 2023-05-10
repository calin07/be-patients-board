package com.example.demo.controller;

import com.example.demo.dto.AdmissionTypeDTO;
import com.example.demo.dto.InsuranceStatusDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.exception.InvalidSpecialityIdException;
import com.example.demo.service.AdmissionTypeService;
import com.example.demo.service.InsuranceStatusService;
import com.example.demo.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;
    private final AdmissionTypeService admissionTypeService;
    private final InsuranceStatusService insuranceStatusService;

    public PatientController(PatientService patientService, AdmissionTypeService admissionTypeService, InsuranceStatusService insuranceStatusService) {
        this.patientService = patientService;
        this.admissionTypeService = admissionTypeService;
        this.insuranceStatusService = insuranceStatusService;
    }

    @GetMapping("/typeOfAdmissions")
    public List<AdmissionTypeDTO> getAdmissionTypes() {
        return admissionTypeService.getAdmissionTypes();
    }

    @GetMapping("/insuranceStatus")
    public List<InsuranceStatusDTO> getInsuranceStatus() {
        return insuranceStatusService.getInsuranceStatus();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PatientDTO>>filterPatientsBySpeciality(@RequestParam List<Long> specialityIds){
        try {
            List<PatientDTO> filteredPatients = patientService.sortPatientsBySpeciality(specialityIds);
            return ResponseEntity.ok(filteredPatients);
        } catch (InvalidSpecialityIdException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
