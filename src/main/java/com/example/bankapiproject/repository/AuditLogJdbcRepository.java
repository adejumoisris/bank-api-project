package com.example.bankapiproject.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuditLogJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public AuditLogJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void logAction(String action, String username, String accountNumber) {
        String sql = """
            INSERT INTO audit_logs(action, username, account_number, created_at)
            VALUES (?, ?, ?, NOW())
        """;
        jdbcTemplate.update(sql, action, username, accountNumber);
    }
}
