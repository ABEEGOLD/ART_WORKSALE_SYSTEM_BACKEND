package com.semicolon.africa.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User buyer;

    @ManyToOne
    private ArtWork artwork;

    private BigDecimal pricePaid;

    private LocalDateTime purchaseDate;

    private PurchaseStatus status; // COMPLETED, PENDING, REFUNDED, etc

}
