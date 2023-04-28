package com.example.demo.controller;
import com.example.demo.dto.InsuranceTypeDTO;
import com.example.demo.service.InsuranceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private InsuranceTypeService insuranceTypeService;
    @GetMapping("/typeOfInsurances")
    public List<InsuranceTypeDTO> getStatus(){
        return insuranceTypeService.getfindAllInsuranceType();
    }
}
