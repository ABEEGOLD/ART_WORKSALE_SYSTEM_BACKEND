package com.semicolon.africa.services;

import com.semicolon.africa.data.models.ArtWork;
import com.semicolon.africa.data.repositories.ArtWorkRepository;
import com.semicolon.africa.dtos.requests.ArtWorkRequest;
import com.semicolon.africa.dtos.response.ArtWorkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtWorkServiceImpl implements ArtWorkService {
    @Autowired
    private ArtWorkRepository artWorkRepository;

    @Override
 public ArtWorkResponse create_Artwork(ArtWorkRequest request){
        ArtWork art = new ArtWork();
        art.setId(request.getId());
        art.setDescription(request.getDescription());
        art.setCategory(request.getCategory());
        art.setPrice(request.getPrice());
        art.setImageUrl(request.getImageUrl());
        art.setSold(request.isSold());
        art.setSold(request.isSold());
//        System.out.println("True" + request.isSold());
        artWorkRepository.save(art);

        ArtWorkResponse response = new ArtWorkResponse();
        response.setMessage("Artwork has been created");
        return response;
    }

    @Override
    public ArtWorkResponse getAllArtWork(ArtWorkRequest request){
        List<ArtWork> artWorks = artWorkRepository.findAllById(request.getId());
        for(ArtWork artWork : artWorks){
            artWork.setDescription(request.getDescription());
            artWork.setCategory(request.getCategory());
            artWork.setPrice(request.getPrice());
            artWork.setImageUrl(request.getImageUrl());
            artWork.setSold(request.isSold());
            artWork.setSold(request.isSold());
//            System.out.println("Not sold" +  request.isSold());
        }
        ArtWorkResponse response = new ArtWorkResponse();
        response.setMessage("All Artwork has been retrieved");
        return response;
    }

//    @Override
//    public ArtWorkResponse update_artWork(){
//
//    }
}
