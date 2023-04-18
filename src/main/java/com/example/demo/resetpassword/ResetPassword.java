package com.example.demo.resetpassword;

public class ResetPassword {
    private String requestId;
    private String newPassword;
    private User user;

    public ResetPassword(String requestId, String newPassword) {
        this.requestId = requestId;
        this.newPassword = newPassword;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
