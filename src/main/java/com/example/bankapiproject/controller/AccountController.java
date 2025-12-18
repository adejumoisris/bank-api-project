package com.example.bankapiproject.controller;

import com.example.bankapiproject.entity.Transaction;
import com.example.bankapiproject.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountNumber}/balance")
    public ResponseEntity<BigDecimal> getBalance(
            @PathVariable String accountNumber,
            @RequestParam String username) throws AccountNotFoundException {
        return ResponseEntity.ok(accountService.getBalance(accountNumber, username));
    }

    @GetMapping("/{accountNumber}/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(
            @PathVariable String accountNumber,
            @RequestParam String username) {
        return ResponseEntity.ok(accountService.getTransactions(accountNumber, username));
    }
}
