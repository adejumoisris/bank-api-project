package com.example.bankapiproject.repository;

import com.example.bankapiproject.entity.RowMappers;
import com.example.bankapiproject.entity.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TransactionJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public TransactionJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Transaction> findByAccountNumber(String accountNumber) {
        String sql = """
            SELECT id, account_number, type, amount, created_at
            FROM transactions
            WHERE account_number = ?
            ORDER BY created_at DESC
        """;
        return jdbcTemplate.query(sql, RowMappers.transactionRowMapper(), accountNumber);
    }

    public void save(Transaction transaction) {
        String sql = "INSERT INTO transactions(account_number, type, amount, created_at) VALUES (?, ?, ?, NOW())";
        jdbcTemplate.update(sql, transaction.getAccountNumber(), transaction.getType(), transaction.getAmount());
    }
}
