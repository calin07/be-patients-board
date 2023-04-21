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

    public List<Function> getFunctions() {
        startup();
        ObjectMapper objectMapper = new ObjectMapper();

        for(Function function : functionRepository.findAll()) {
            Map<String, Object> object = new HashMap<>();
            object.put("id", function.getId());
            object.put("name", function.getName());

        }

        return new ArrayList<>();
    }

    void startup() {
        Function f1 = new Function(); f1.setId(1L); f1.setName("Neurologie");
        functionRepository.save(f1);
        Function f2 = new Function(); f2.setId(2L); f2.setName("Cardiologie");
        functionRepository.save(f2);

        Speciality s1 = new Speciality(); s1.setId(1L); s1.setName("Neuroradiologie"); s1.setFunction(f1);
        specialityRepository.save(s1);
        Speciality s2 = new Speciality(); s2.setId(2L); s2.setName("Neurochirurgie"); s2.setFunction(f1);
        specialityRepository.save(s2);
        Speciality s3 = new Speciality(); s3.setId(3L); s3.setName("Electrofiziologie cardiacă"); s3.setFunction(f2);
        specialityRepository.save(s3);
    }
}
