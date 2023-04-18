package com.example.demo.login.controller;
import com.example.demo.login.exception.UserException;
import com.example.demo.login.service.UserRequest;
import com.example.demo.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserRequest userRequest){
        try {
            String token=userService.login(userRequest.getEmail(),userRequest.getPassword());
            return ResponseEntity.ok(token);
        }catch (UserException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}
