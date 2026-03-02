package com.semicolon.africa.services;

import com.semicolon.africa.data.models.ArtWork;
import com.semicolon.africa.data.models.Artist;
import com.semicolon.africa.data.models.StatusArtwork;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.ArtWorkRepository;
import com.semicolon.africa.data.repositories.ArtistRepository;
import com.semicolon.africa.dtos.requestsArtWork.*;
import com.semicolon.africa.dtos.responseArtWork.*;
import com.semicolon.africa.exceptions.ArtWorkNotUpdatedException;
import com.semicolon.africa.exceptions.ArtistNotFoundException;
import com.semicolon.africa.exceptions.ArtworkNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtWorkServiceImpl implements ArtWorkService {
    @Autowired
    private ArtWorkRepository artWorkRepository;
    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public CreateArtWorkResponse createArtwork(CreateArtWorkRequest request){

        if(request.getArtistId() == null){
            throw new ArtistNotFoundException("Artist Id Not Found");
        }
        Artist artist = artistRepository.findById(request.getArtistId())
                .orElseThrow(() -> new RuntimeException("Artist not found"));

        ArtWork art = new ArtWork();

        art.setDescription(request.getDescription());
        art.setTitle(request.getTitle());
        art.setCreatedDate(LocalDateTime.now());
        art.setPrice(request.getPrice());
        art.setImageUrl("Upload.xml");
        art.setStatus(StatusArtwork.AVAILABLE);
        art.setArtist(artist.getUser());


        ArtWork saved = artWorkRepository.save(art);

        CreateArtWorkResponse response = new CreateArtWorkResponse();
        response.setId(saved.getId());
        response.setMessage("Artwork has been created successfully");
        return response;
    }


    @Override
    public List<GetAllArtWorkResponse> getAllArtWork() {

        List<ArtWork> artWorks = artWorkRepository.findAll();

        return artWorks.stream()
                .map(art -> {
                    GetAllArtWorkResponse response = new GetAllArtWorkResponse();
                    response.setTitle(art.getTitle());
                    response.setDescription(art.getDescription());
                    response.setPrice(art.getPrice());
                    response.setImageUrl(art.getImageUrl());
                    response.setStatus(art.getStatus());
                    return response;
                })
                .collect(Collectors.toList());
    }



    @Override
    public UpdateArtWorkResponse updateArtWork(UpdateArtWorkRequest request) {

        ArtWork art = artWorkRepository.findById(request.getId())
                .orElseThrow(() -> new ArtWorkNotUpdatedException("Artwork not found"));

        art.setTitle(request.getTitle());
        art.setDescription(request.getDescription());
        art.setPrice(new BigDecimal("300.00"));
        art.setImageUrl(request.getImageUrl());

        artWorkRepository.save(art);

        UpdateArtWorkResponse response = new UpdateArtWorkResponse();
        response.setMessage("Artwork has been updated successfully");
        return response;
    }

@Override
 public MarkSoldArtWorkResponse markAsSold(MarkSoldArtWorkRequest request) {
        ArtWork art = artWorkRepository.findById(request.getId())
                .orElseThrow(() -> new ArtworkNotFoundException("Artwork not found"));
    if(!art.getStatus().equals(StatusArtwork.SOLD)){
        art.setStatus(StatusArtwork.SOLD);
        artWorkRepository.save(art);
    }else {
        throw new ArtWorkNotUpdatedException("Artwork is already sold");
    }
    MarkSoldArtWorkResponse response = new MarkSoldArtWorkResponse();
        response.setMessage("Artwork has been marked as sold successfully");
        return response;

}
@Override
  public DeleteArtWorkResponse deleteArtWork(Long id){
        ArtWork art = artWorkRepository.findById(id)
                .orElseThrow(() -> new ArtworkNotFoundException("Artwork not found"));
        artWorkRepository.delete(art);

        DeleteArtWorkResponse response = new DeleteArtWorkResponse();
        response.setMessage("Artwork has been deleted successfully");
        return response;
}


}
