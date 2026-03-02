package com.semicolon.africa.dtos.responseUser;

import com.semicolon.africa.data.models.PurchaseStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PurchaseArtWorkResponse {
    private String artworkTitle;
    private BigDecimal price;
    private PurchaseStatus status; // COMPLETED, FAILED, PENDING
    private LocalDateTime purchaseDate;
    private String transactionId;
    private String message;


}
