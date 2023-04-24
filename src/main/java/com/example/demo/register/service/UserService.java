package com.example.demo.register.service;

import com.example.demo.model.User;
import com.example.demo.register.exception.ConfirmPasswordException;
import com.example.demo.register.exception.InvalidEmailException;
import com.example.demo.register.exception.InvalidPasswordException;
import com.example.demo.register.exception.UserException;
import com.example.demo.register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user) throws UserException {
        validateUser(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    private void validateUser(User user) throws UserException {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new InvalidEmailException("An account with this email address already exists. " +
                    "Please try logging in or use a different email address");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new ConfirmPasswordException("Passwords do not match. " +
                    "Please make sure you've entered the same password in both fields");
        }
        if (user.getPassword().length() < MIN_PASSWORD_LENGTH) {
            throw new InvalidPasswordException("Password must have at least " + MIN_PASSWORD_LENGTH + " characters");
        }
    }
}