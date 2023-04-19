package com.cegeka.java.academy.register.controller;

import com.cegeka.java.academy.model.User;
import com.cegeka.java.academy.register.exception.ConfirmPasswordException;
import com.cegeka.java.academy.register.exception.InvalidEmailException;
import com.cegeka.java.academy.register.exception.InvalidPasswordException;
import com.cegeka.java.academy.register.exception.UserException;
import com.cegeka.java.academy.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            userService.register(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InvalidEmailException e) {
            return new ResponseEntity<>("Invalid email format", HttpStatus.BAD_REQUEST);
        } catch (ConfirmPasswordException e) {
            return new ResponseEntity<>("Passwords do not match", HttpStatus.BAD_REQUEST);
        } catch (InvalidPasswordException e) {
            return new ResponseEntity<>("Invalid password format. Password must have at least 8 characters", HttpStatus.BAD_REQUEST);
        } catch (UserException e) {
            return new ResponseEntity<>("Unable to register user. Please try again later", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}