package com.cegeka.java.academy.register.controller;

import com.cegeka.java.academy.model.User;
import com.cegeka.java.academy.register.exception.UserException;
import com.cegeka.java.academy.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody User user) throws UserException {
        userService.register(user);
    }
}