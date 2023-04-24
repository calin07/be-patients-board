package com.example.demo.functions.controller;

import com.example.demo.functions.service.FunctionService;
import com.example.demo.model.Function;
import com.example.demo.model.User;
import com.example.demo.register.exception.ConfirmPasswordException;
import com.example.demo.register.exception.InvalidEmailException;
import com.example.demo.register.exception.InvalidPasswordException;
import com.example.demo.register.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
