package com.example.bankapiproject.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String accountNumber;
    @Column(nullable = false)
    private BigDecimal balance;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
