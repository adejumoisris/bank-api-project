package com.example.bankapiproject.entity;

import java.time.LocalDateTime;

public class AuditLog {

    private Long id;
    private String action;
    private String username;
    private String accountNumber;
    private LocalDateTime createdAt;

    public AuditLog(Long id, String action, String username, String accountNumber, LocalDateTime createdAt) {
        this.id = id;
        this.action = action;
        this.username = username;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
    }

    public AuditLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", username='" + username + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
