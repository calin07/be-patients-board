package com.example.demo.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ResetPasswordRequest")
public class ResetPasswordRequest {
    private String newPassword;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "requestId")
    private UUID requestId = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public ResetPasswordRequest(UUID requestId) {
        this.requestId = requestId;
    }

    public ResetPasswordRequest(UUID requestId, String newPassword) {
        this.requestId = requestId;
        this.newPassword = newPassword;
    }

    public ResetPasswordRequest() {

    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
