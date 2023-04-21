package com.example.demo.functions.service;

import com.example.demo.functions.repositories.FunctionRepository;
import com.example.demo.functions.repositories.SpecialityRepository;
import com.example.demo.model.Function;
import com.example.demo.model.Speciality;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FunctionService {

    private final FunctionRepository functionRepository;
    private final SpecialityRepository specialityRepository;

    public FunctionService(FunctionRepository functionRepository, SpecialityRepository specialityRepository) {
        this.functionRepository = functionRepository;
        this.specialityRepository = specialityRepository;
    }

    public List<Map<String, Object>> getFunctions() {
        List<Map<String, Object>> result = new ArrayList<>();

        for(Function function : functionRepository.findAll()) {
            Map<String, Object> functionObject = new HashMap<>();
            functionObject.put("id", function.getId());
            functionObject.put("name", function.getName());
            List<Map<String, Object>> specialitiesDetailsList = new ArrayList<>();

            for(Speciality speciality : specialityRepository.findAllByFunction_Id(function.getId())) {
                Map<String, Object> specialityObject = new HashMap<>();
                specialityObject.put("id", speciality.getId());
                specialityObject.put("name", speciality.getName());
                specialitiesDetailsList.add(specialityObject);
            }

            functionObject.put("specialities", specialitiesDetailsList);
            result.add(functionObject);
        }

        return result;
    }
}
