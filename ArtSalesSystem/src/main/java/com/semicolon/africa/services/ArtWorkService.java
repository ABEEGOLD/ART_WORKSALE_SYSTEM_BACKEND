package com.semicolon.africa.services;

import com.semicolon.africa.dtos.requests.ArtWorkRequest;
import com.semicolon.africa.dtos.response.ArtWorkResponse;

public interface ArtWorkService {
    ArtWorkResponse create_Artwork(ArtWorkRequest request);
    ArtWorkResponse getAllArtWork(ArtWorkRequest request);

}
