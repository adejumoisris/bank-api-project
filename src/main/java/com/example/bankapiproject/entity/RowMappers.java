package com.example.bankapiproject.entity;

import org.springframework.jdbc.core.RowMapper;

public class RowMappers {
    public static RowMapper<Transaction> transactionRowMapper() {
        return (rs, rowNum) -> {
            Transaction tx = new Transaction();
            tx.setId(rs.getLong("id"));
            tx.setAccountNumber(rs.getString("account_number"));
            tx.setType(rs.getString("type"));
            tx.setAmount(rs.getBigDecimal("amount"));
            tx.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            return tx;
        };
    }
}
