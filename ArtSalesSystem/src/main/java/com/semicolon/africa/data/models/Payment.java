package com.semicolon.africa.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentProvider;
    private String transactionId;
    private Double amount;
    private String currency = "USD";
    private String status; // succeeded,failed, pending

    private LocalDateTime paymentDate = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

}
