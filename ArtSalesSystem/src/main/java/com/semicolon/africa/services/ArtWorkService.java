package com.semicolon.africa.services;

import com.semicolon.africa.dtos.requests.*;
import com.semicolon.africa.dtos.response.*;

import java.util.List;

public interface ArtWorkService {
    CreateArtWorkResponse createArtwork(CreateArtWorkRequest request);
    List<GetAllArtWorkResponse> getAllArtWork();
    UpdateArtWorkResponse updateArtWork(UpdateArtWorkRequest request);
    MarkSoldArtWorkResponse markAsSold(MarkSoldArtWorkRequest request);
    DeleteArtWorkResponse deleteArtWork(Long id);
}
