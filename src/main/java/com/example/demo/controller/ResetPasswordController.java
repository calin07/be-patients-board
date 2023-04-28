package com.example.demo.controller;// Importam clasele necesare

import com.example.demo.exception.ResetPasswordException;
import com.example.demo.model.ResetPasswordRequest;
import com.example.demo.dto.EmailRequest;
import com.example.demo.service.ResetPasswordService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/reset-password")
public class ResetPasswordController {

    // Injectam serviciul de resetare parola
    @Autowired
    private ResetPasswordService resetPasswordService;

    // Endpoint-ul pentru resetarea parolei
    @PutMapping
    public ResponseEntity<String> resetPassword(ResetPasswordRequest request) { // FIXME de folosit un DTO in loc de entitate
        try {
            resetPasswordService.resetPassword(request);

            // Returnam un raspuns cu status 200 in caz de succes
            return ResponseEntity.ok().build();
        } catch (ResetPasswordException e) {
            // In caz de eroare, returnam un raspuns cu status 400 si mesajul de eroare
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping // TODO merge la pachetul resetPasswordRequest cu resetpassword
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){
        try{
            resetPasswordService.saveRequest(emailRequest.getEmail());
            return ResponseEntity.ok().build();
        }catch (ResetPasswordException | MessagingException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}