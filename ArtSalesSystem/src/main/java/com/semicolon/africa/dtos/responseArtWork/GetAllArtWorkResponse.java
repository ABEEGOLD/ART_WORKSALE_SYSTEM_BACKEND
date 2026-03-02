package com.semicolon.africa.dtos.responseArtWork;

import com.semicolon.africa.data.models.StatusArtwork;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class GetAllArtWorkResponse {
    private String message;
    private String title;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private StatusArtwork status = StatusArtwork.AVAILABLE;


}
