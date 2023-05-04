package com.example.demo.service;

import com.example.demo.dto.PatientDTO;
import com.example.demo.exception.InvalidSpecialityIdException;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    private final SpecialityRepository specialityRepository;

    public PatientService(PatientRepository patientRepository, SpecialityRepository specialityRepository) {
        this.patientRepository = patientRepository;
        this.specialityRepository = specialityRepository;
    }

    public List<PatientDTO> sortPatientsBySpeciality(List<Long> specialityIds) {
        for (Long specialityId : specialityIds) {
            if (!specialityRepository.existsById(specialityId)) {
                throw new InvalidSpecialityIdException("Invalid speciality ID: " + specialityId);
            }
        }

        List<Patient> filteredPatients = patientRepository.findBySpeciality_IdIn(specialityIds);
        filteredPatients.sort((s1,s2) -> {
            if(s1.getSpeciality().getId().equals(s2.getSpeciality().getId())){
                return s1.getSpeciality().getName().compareTo(s2.getSpeciality().getName());
            }
            else{
                return s1.getSpeciality().getId().compareTo(s2.getSpeciality().getId());
            }
        });

        List<PatientDTO> sortedPatientsDTO = new ArrayList<>();
        for (Patient patient: filteredPatients) {
            PatientDTO patientDTO = new PatientDTO(patient.getId(),patient.getFirstName(),patient.getLastName(),patient.getSpeciality().getName(),patient.getRoom().getName(),patient.getAdmissionDate(),patient.getSpeciality().getId());
            sortedPatientsDTO.add(patientDTO);
        }
        return sortedPatientsDTO;
    }
}
