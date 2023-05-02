package com.example.demo.service;

import com.example.demo.model.ResetPasswordRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.exception.ResetPasswordException;
import com.example.demo.repository.ResetPasswordRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

@Service
public class ResetPasswordService {

    @Value("${server.port}")
    private int serverPort;

    // Injectam repository-ul de resetare parola
    @Autowired
    private ResetPasswordRepository resetPasswordRepository;

    // Injectam repository-ul de utilizatori
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public void saveRequest(String email) throws ResetPasswordException, MessagingException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new ResetPasswordException("The email does not exist");
        } else {
            ResetPasswordRequest passwordRequest = new ResetPasswordRequest();
            passwordRequest.setUser(user.get());
            String dateTime = LocalDateTime.now().toString();
            UUID requestId = UUID.nameUUIDFromBytes((user.get().getEmail() + dateTime).getBytes());
            passwordRequest.setRequestId(requestId);
            resetPasswordRepository.save(passwordRequest);
            String link = "http://localhost:"+serverPort+"/user/reset-password?requestId=" + requestId; // TODO de scos in proprietate statica
            String text = "<p>Pentru resetarea parolei,va rugam sa accesati acest <a href=\"" + link + "\">" + "link" + "</a>.</p>";
            emailSenderService.sendEmail(email, "Reset Password", text);
        }
    }

    public void resetPassword(ResetPasswordRequest request) throws ResetPasswordException {
        // Cautam cererea de resetare a parolei dupa requestId
        ResetPasswordRequest resetPassword = findByRequestId(request.getRequestId());

        // Actualizam parola utilizatorului
//        FIXME de folosit newPassword din noul DTO ResetPasswordRequest
//        updatePassword(resetPassword.getUser(), request.getNewPassword());

        // Salvam parola noua in baza de date
        savePassword(resetPassword.getUser());
    }

    // Metoda pentru a cauta cererea de resetare a parolei dupa requestId
    private ResetPasswordRequest findByRequestId(UUID requestId) throws ResetPasswordException {
        // Cautam cererea de resetare a parolei in baza de date
        Optional<ResetPasswordRequest> optionalResetPassword = resetPasswordRepository.findByRequestId(requestId);

        // Verificam daca cererea a fost gasita in baza de date
        if (optionalResetPassword.isPresent()) {
            return optionalResetPassword.get();
        } else {
            throw new ResetPasswordException("Cererea de resetare a parolei nu a fost gasita");
        }
    }

    // Metoda pentru a actualiza parola utilizatorului
    private void updatePassword(User user, String newPassword) throws ResetPasswordException {
        // Verificam daca parola este valida
        if (!isValidPassword(newPassword)) {
            throw new ResetPasswordException("Parola invalida");
        }

        // Actualizam parola utilizatorului
        user.setPassword(newPassword); // TODO de criptat parola
    }

    // Metoda pentru a salva parola actualizata in baza de date
    private void savePassword(User user) {
        userRepository.save(user);
    }

    // Metoda pentru a valida parola
    private boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
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

