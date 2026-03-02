package com.semicolon.africa.dtos.requestsArtWork;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllArtWorkRequest {
    private Long id;
    private String description;
    private String title;
    private String imageUrl;
    private String price;

}
