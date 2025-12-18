package com.example.bankapiproject.dto;

import java.math.BigDecimal;

public class AccountDto {
    private String accountNumber;
    private BigDecimal balance;
    private String customerName;

    public AccountDto(String accountNumber, BigDecimal balance, String customerName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
    }

    public AccountDto() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
