package com.example.demo.service;
import com.example.demo.dto.InsuranceTypeDTO;
import com.example.demo.model.InsuranceType;
import com.example.demo.repository.InsuranceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class InsuranceTypeService {
    @Autowired
    private  InsuranceTypeRepository insuranceTypeRepository;
    public List<InsuranceTypeDTO> getAllInsuranceTypes(){
        List<InsuranceTypeDTO> typeDTOList=new ArrayList<>();
        List<InsuranceType> insuranceTypes=insuranceTypeRepository.findAll();
        for(InsuranceType insuranceType:insuranceTypes){
            typeDTOList.add(convertInsuranceTypeDTO(insuranceType));
            }
        return typeDTOList;
    }

    private InsuranceTypeDTO convertInsuranceTypeDTO(InsuranceType insuranceType){
        InsuranceTypeDTO insuranceTypeDTO=new InsuranceTypeDTO();
        insuranceTypeDTO.setType(insuranceType.getType());
        return insuranceTypeDTO;
    }
}
