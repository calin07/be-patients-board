package com.example.demo.service;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;
import com.example.demo.exception.InvalidEmailException;
import com.example.demo.exception.InvalidPasswordException;
import com.example.demo.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user) throws UserException {
        validateUser(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //FIXME de setat Speciality-ul user-ului pe baza specialtyId-ului primit pe request
        userRepository.save(user);
    }

    private void validateUser(User user) throws UserException {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new InvalidEmailException("An account with this email address already exists. " +
                    "Please try logging in or use a different email address");
        }
//      FIXME de luat confirm password din DTO-ul venit din request, nu din entitate
//       if (!user.getPassword().equals(user.getConfirmPassword())) {
//            throw new ConfirmPasswordException("Passwords do not match. " +
//                    "Please make sure you've entered the same password in both fields");
//        }
        if (user.getPassword().length() < MIN_PASSWORD_LENGTH) {
            throw new InvalidPasswordException("Password must have at least " + MIN_PASSWORD_LENGTH + " characters");
        }
    }

    public String login(String email, String password) throws com.example.demo.exception.UserException {
        Optional<User> user = userRepository.findByEmail(email);
        String passwordEncoder1 = passwordEncoder.encode(password);
        if (user.isPresent() && passwordEncoder1.equals(user.get().getPassword())) {
            //Jetonul JWT semnat cu HMAC
            String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
            Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                    SignatureAlgorithm.HS256.getJcaName());
            return Jwts.builder()
                    .claim("email", user.get().getEmail())
                    .claim("password", user.get().getPassword())
                    .setSubject("user")
                    .setIssuedAt(Date.from(Instant.now()))
                    .setExpiration(Date.from(Instant.now().plus(5l, ChronoUnit.MINUTES)))
                    .signWith(hmacKey)
                    .compact();
        } else {
            throw new com.example.demo.exception.UserException("Please check your password and account name and try again");
        }
    }
}