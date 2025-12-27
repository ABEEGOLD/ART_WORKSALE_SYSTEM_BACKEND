package com.semicolon.africa.dtos.requestUser;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PurchaseArtWorkRequest {
    private Long userId;
    private  Long artworkId;
    private String paymentMethod;


}
