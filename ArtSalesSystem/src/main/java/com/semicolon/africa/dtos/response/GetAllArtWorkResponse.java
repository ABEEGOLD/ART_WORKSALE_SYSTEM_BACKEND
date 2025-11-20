package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.models.ArtWork;
import com.semicolon.africa.data.models.StatusArtwork;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
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
