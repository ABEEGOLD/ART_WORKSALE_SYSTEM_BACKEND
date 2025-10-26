package com.semicolon.africa.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtWorkRequest {
    private Long id;
    private String title;
    private String description;
    private String category;
    private int price;
    private String imageUrl;
    private boolean sold = false;

}
