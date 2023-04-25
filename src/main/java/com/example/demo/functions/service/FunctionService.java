package com.example.demo.functions.service;

import com.example.demo.model.Function;
import com.example.demo.model.Speciality;
import com.example.demo.repository.FunctionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class FunctionService {

    private final FunctionRepository functionRepository;

    public FunctionService(FunctionRepository functionRepository) {
        this.functionRepository = functionRepository;
    }

    public List<Function> getFunctions() {
        return functionRepository.findAll();
    }
}
