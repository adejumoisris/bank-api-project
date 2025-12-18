package com.example.bankapiproject.service;

import com.example.bankapiproject.entity.Account;
import com.example.bankapiproject.entity.Transaction;
import com.example.bankapiproject.repository.AccountRepository;
import com.example.bankapiproject.repository.AuditLogJdbcRepository;
import com.example.bankapiproject.repository.TransactionJdbcRepository;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final TransactionJdbcRepository transactionRepository;
    private final AuditLogJdbcRepository auditLogRepository;

    public AccountService(AccountRepository accountRepository, TransactionJdbcRepository transactionRepository, AuditLogJdbcRepository auditLogRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.auditLogRepository = auditLogRepository;
    }

    public BigDecimal getBalance(String accountNumber, String username) throws AccountNotFoundException {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException(accountNumber));

        auditLogRepository.logAction("CHECK_BALANCE", username, accountNumber);
        return account.getBalance();
    }

    public List<Transaction> getTransactions(String accountNumber, String username) {
        auditLogRepository.logAction("VIEW_TRANSACTIONS", username, accountNumber);
        return transactionRepository.findByAccountNumber(accountNumber);
    }
}
