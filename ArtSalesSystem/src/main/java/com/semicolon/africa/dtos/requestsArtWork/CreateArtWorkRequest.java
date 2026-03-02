package com.semicolon.africa.dtos.requestsArtWork;

import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class CreateArtWorkRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistId;
    private String title;
    @Column(length = 1000)
    private String description;
    private BigDecimal price;


}
