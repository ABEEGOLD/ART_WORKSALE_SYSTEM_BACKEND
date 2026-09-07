package com.semicolon.africa.services;

import com.semicolon.africa.data.models.ArtWork;
import com.semicolon.africa.data.repositories.ArtWorkRepository;
import com.semicolon.africa.data.repositories.ArtistRepository;
import com.semicolon.africa.dtos.requestArtist.RequestArtist;
import com.semicolon.africa.dtos.respondArtist.RespondArtist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService{
    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtWorkRepository artWorkRepository;

    @Override
    public RespondArtist registerArtist(RequestArtist requestArtist) {
        return null;
    }

    @Override
    public RespondArtist getArtistById(Long id) {
        return null;
    }

    @Override
    public List<RespondArtist> getAllArtists() {
        return List.of();
    }

    @Override
    public RespondArtist updateArtist(Long id, RequestArtist requestArtist) {
        return null;
    }

    @Override
    public void deleteArtist(Long id) {

    }

    @Override
    public List<ArtWork> getArtworksByArtist(Long artistId) {
        return List.of();
    }




}
