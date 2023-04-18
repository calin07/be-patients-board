package com.example.demo.resetpassword;

public class ResetPasswordRequest {
    private final String requestId;
    private String newPassword;

    public ResetPasswordRequest(String requestId) {
        this.requestId = requestId;
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
