package com.example.demo.resetPasswordRequest.controller;

import com.example.demo.resetPasswordRequest.exception.ResetPasswordException;
import com.example.demo.resetPasswordRequest.service.EmailRequest;
import com.example.demo.resetPasswordRequest.service.ResetPasswordService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ResetPasswordController {
    @Autowired
    private ResetPasswordService resetPasswordService;

    @PostMapping("/reset-password")
    public ResponseEntity<Object> sendEmail(@RequestBody EmailRequest emailRequest){
        try{
            resetPasswordService.saveRequest(emailRequest.getEmail());
            return ResponseEntity.ok().build();
        }catch (ResetPasswordException | MessagingException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
