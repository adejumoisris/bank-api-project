package com.example.bankapiproject.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    private String type;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    public TransactionDto(String type, BigDecimal amount, LocalDateTime createdAt) {
        this.type = type;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public TransactionDto() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                '}';
    }
}
