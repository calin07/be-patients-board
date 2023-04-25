package com.example.demo.resetpassword.controller;// Importam clasele necesare

import com.example.demo.model.ResetPasswordRequest;
import com.example.demo.resetpassword.exception.ResetPasswordException;
import com.example.demo.resetpassword.service.ResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ResetPasswordController {

    // Injectam serviciul de resetare parola
    @Autowired
    private ResetPasswordService resetPasswordService;

    // Endpoint-ul pentru resetarea parolei
    @PutMapping("/user/reset-password")
    public ResponseEntity resetPassword(@RequestBody ResetPasswordRequest request) { // FIXME de folosit un DTO in loc de entitate
        try {
            resetPasswordService.resetPassword(request);

            // Returnam un raspuns cu status 200 in caz de succes
            return ResponseEntity.ok().build();
        } catch (ResetPasswordException e) {
            // In caz de eroare, returnam un raspuns cu status 400 si mesajul de eroare
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}