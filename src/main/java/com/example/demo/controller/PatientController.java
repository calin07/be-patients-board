package com.example.demo.controller;

import com.example.demo.dto.PatientDTO;
import com.example.demo.exception.InvalidSpecialityIdException;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.dto.AdmissionTypeDTO;
import com.example.demo.dto.InsuranceStatusDTO;
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
    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/filter")
    @Secured("ROLE_USER") // Asigură că doar utilizatorii autentificați pot accesa acest endpoint
    public ResponseEntity<List<PatientDTO>>filterPatientsBySpeciality(@RequestParam List<Long> specialityIds){
        try {
            List<PatientDTO> filteredPatients = patientService.sortPatientsBySpeciality(specialityIds);
            return ResponseEntity.ok(filteredPatients);
        } catch (InvalidSpecialityIdException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

    private final AdmissionTypeService admissionTypeService;
    private final InsuranceStatusService insuranceStatusService;

    public PatientController(AdmissionTypeService admissionTypeService, InsuranceStatusService insuranceStatusService) {
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
}
