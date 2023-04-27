package com.example.demo.dto;

import java.util.UUID;

public class ResetPasswordRequestDTO {
    private UUID requestId;
    private String newPassword;

    public ResetPasswordRequestDTO(){}

    public ResetPasswordRequestDTO(UUID requestId, String newPassword) {
        this.requestId = requestId;
        this.newPassword = newPassword;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
