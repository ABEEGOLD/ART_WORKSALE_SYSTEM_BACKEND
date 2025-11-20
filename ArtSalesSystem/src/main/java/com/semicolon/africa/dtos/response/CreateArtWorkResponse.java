package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateArtWorkResponse {
    private Long id;
    private String description;
    private String size;
    private BigDecimal price;
    private String message;


}
