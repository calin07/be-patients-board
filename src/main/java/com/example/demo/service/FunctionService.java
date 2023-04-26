package com.example.demo.service;

import com.example.demo.model.Function;
import com.example.demo.repository.FunctionRepository;
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
