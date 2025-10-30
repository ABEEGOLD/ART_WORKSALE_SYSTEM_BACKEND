package com.semicolon.africa.services;

import com.semicolon.africa.dtos.requests.ArtWorkRequest;
import com.semicolon.africa.dtos.response.ArtWorkResponse;

public interface ArtWorkService {
    ArtWorkResponse createArtwork(ArtWorkRequest request);
    ArtWorkResponse getAllArtWork(ArtWorkRequest request);
    ArtWorkResponse updateArtWork(ArtWorkRequest request);
    ArtWorkResponse markAsSold(ArtWorkRequest request);
    ArtWorkResponse deleteArtWork(Long id);
}
