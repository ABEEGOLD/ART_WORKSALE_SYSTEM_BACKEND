package com.semicolon.africa.services;

import com.semicolon.africa.data.models.ArtWork;
import com.semicolon.africa.dtos.requestArtist.RequestArtist;
import com.semicolon.africa.dtos.respondArtist.RespondArtist;

import java.util.List;

public interface ArtistService {

    RespondArtist registerArtist(RequestArtist requestArtist);
    RespondArtist getArtistById(Long id);
    List<RespondArtist> getAllArtists();
    RespondArtist updateArtist(Long id, RequestArtist requestArtist);
    RespondArtist deleteArtist(Long id);
    List<ArtWork> getArtworksByArtist(Long artistId);

}
