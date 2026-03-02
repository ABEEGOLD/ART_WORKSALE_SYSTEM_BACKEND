package com.semicolon.africa.dtos.requestsArtWork;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtWorkRequest {
    private Long id;
    private String title;
    private String description;
    private int price;
    private String imageUrl;
    private boolean sold = false;

}
