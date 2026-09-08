package com.semicolon.africa.dtos.responseArtWork;

import com.semicolon.africa.data.models.ArtWork;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtWorkResponse {
    private String message;
    private ArtWork artWork;
}
