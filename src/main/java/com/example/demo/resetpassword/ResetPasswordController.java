package com.example.demo.resetpassword;// Importam clasele necesare

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
    public ResponseEntity resetPassword(@RequestBody ResetPasswordRequest request) {
        try {
            // Cautam cererea de resetare a parolei dupa requestId
            ResetPassword resetPassword = resetPasswordService.findByRequestId(request.getRequestId());

            // Actualizam parola utilizatorului
            resetPasswordService.updatePassword(resetPassword.getUser(), request.getNewPassword());

            // Salvam parola noua in baza de date
            resetPasswordService.savePassword(resetPassword.getUser());

            // Returnam un raspuns cu status 200 in caz de succes
            return ResponseEntity.ok().build();
        } catch (ResetPasswordException e) {
            // In caz de eroare, returnam un raspuns cu status 400 si mesajul de eroare
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}