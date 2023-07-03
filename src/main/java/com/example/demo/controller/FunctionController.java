package com.example.demo.controller;

import com.example.demo.service.FunctionService;
import com.example.demo.model.Function;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class FunctionController {
    private final FunctionService functionService;

    public FunctionController(FunctionService functionService) {
        this.functionService = functionService;
    }

    @GetMapping("/functions")
    public List<Function> functions() {
        return functionService.getFunctions();
    }
}
