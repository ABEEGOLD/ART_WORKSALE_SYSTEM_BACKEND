package com.semicolon.africa.services;

import com.semicolon.africa.data.models.ArtWork;
import com.semicolon.africa.data.models.Artist;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.ArtWorkRepository;
import com.semicolon.africa.data.repositories.ArtistRepository;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requestArtist.RequestArtist;
import com.semicolon.africa.dtos.respondArtist.RespondArtist;
import com.semicolon.africa.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService{
    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtWorkRepository artWorkRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public RespondArtist registerArtist(RequestArtist requestArtist) {
        User user = userRepository.findById(requestArtist.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + requestArtist.getUserId()));

        Artist artist = new Artist();
        artist.setUser(user);
        artist.setBio(requestArtist.getBio());
        artist.setWebsite(requestArtist.getWebsite());
        artist.setProfileImageUrl(requestArtist.getProfileImageUrl());

        Artist savedArtist = artistRepository.save(artist);

        RespondArtist response = new RespondArtist();
        response.setMessage("Artist registered successfully");
        response.setArtist(savedArtist);
        return response;
    }

    @Override
    public RespondArtist getArtistById(Long id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Artist not found with id: " + id));

        RespondArtist response = new RespondArtist();
        response.setMessage("Artist found");
        response.setArtist(artist);
        return response;
    }

    @Override
    public List<RespondArtist> getAllArtists() {
        List<Artist> artists = artistRepository.findAll();

        return artists.stream()
                .map(artist -> {
                    RespondArtist response = new RespondArtist();
                    response.setMessage("Artist found successfully");
                    response.setArtist(artist);
                    return response;
                })
                .collect(Collectors.toList());
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
