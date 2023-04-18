package com.cegeka.java.academy.register.exception;

public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }

    public static class InvalidEmailException extends UserException {
        public InvalidEmailException(String message) {
            super(message);
        }
    }

    public static class InvalidPasswordException extends UserException {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }

    public static class ConfirmPasswordException extends UserException {
        public ConfirmPasswordException(String message) {
            super(message);
        }
    }
}