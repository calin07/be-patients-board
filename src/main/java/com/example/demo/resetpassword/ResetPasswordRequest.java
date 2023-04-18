package com.example.demo.resetpassword;

public class ResetPasswordRequest {
    private String email;
    private String requestId;
    private String newPassword;

    public ResetPasswordRequest(String email, String requestId) {
        this.email = email;
        this.requestId = requestId;
    }

    public String getEmail() {
        return email;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
