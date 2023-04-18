package com.example.demo.resetpassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResetPasswordService {

    // Injectam repository-ul de resetare parola
    @Autowired
    private ResetPasswordRepository resetPasswordRepository;

    // Injectam repository-ul de utilizatori
    @Autowired
    private UserRepository userRepository;

    // Metoda pentru a cauta cererea de resetare a parolei dupa requestId
    public ResetPassword findByRequestId(String requestId) throws ResetPasswordException {
        // Cautam cererea de resetare a parolei in baza de date
        Optional<ResetPassword> optionalResetPassword = resetPasswordRepository.findByRequestId(requestId);

        // Verificam daca cererea a fost gasita in baza de date
        if (optionalResetPassword.isPresent()) {
            return optionalResetPassword.get();
        } else {
            throw new ResetPasswordException("Cererea de resetare a parolei nu a fost gasita");
        }
    }

    // Metoda pentru a actualiza parola utilizatorului
    public void updatePassword(User user, String newPassword) throws ResetPasswordException {
        // Verificam daca parola este valida
        if (!isValidPassword(newPassword)) {
            throw new ResetPasswordException("Parola invalida");
        }

        // Actualizam parola utilizatorului
        user.setPassword(newPassword);
    }

    // Metoda pentru a salva parola actualizata in baza de date
    public void savePassword(User user) {
        userRepository.save(user);
    }

    // Metoda pentru a valida parola
    private boolean isValidPassword(String password) {
        if (password == null || password.isEmpty() || password.length() < 8) {
            return false; // parola trebuie sa aiba cel putin 8 caractere
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasUppercase && hasLowercase && hasDigit;
    }
}

