package com.example.demo.exception;

public class ResetPasswordException extends RuntimeException{
    public ResetPasswordException(String message) {
        super(message);
    }
}
