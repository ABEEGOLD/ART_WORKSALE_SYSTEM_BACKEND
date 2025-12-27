package com.semicolon.africa.dtos.requestsArtWork;

import com.semicolon.africa.data.models.StatusArtwork;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkSoldArtWorkRequest {
    private Long id;
    private String title;
    private String description;
    private StatusArtwork statusArtwork;

}
