package com.semicolon.africa.services;

import com.semicolon.africa.dtos.requestsArtWork.*;
import com.semicolon.africa.dtos.responseArtWork.*;

import java.util.List;

public interface ArtWorkService {
    CreateArtWorkResponse createArtwork(CreateArtWorkRequest request);
    List<GetAllArtWorkResponse> getAllArtWork();
    UpdateArtWorkResponse updateArtWork(UpdateArtWorkRequest request);
    MarkSoldArtWorkResponse markAsSold(MarkSoldArtWorkRequest request);
    DeleteArtWorkResponse deleteArtWork(Long id);
}
