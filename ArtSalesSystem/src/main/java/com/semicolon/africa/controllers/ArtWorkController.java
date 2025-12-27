package com.semicolon.africa.controllers;

import com.semicolon.africa.dtos.requestsArtWork.CreateArtWorkRequest;
import com.semicolon.africa.dtos.responseArtWork.CreateArtWorkResponse;
import com.semicolon.africa.services.ArtWorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/artworks")
public class ArtWorkController {

    @Autowired
    private ArtWorkServiceImpl artWorkService;

    @PostMapping("/create")
    public ResponseEntity<CreateArtWorkResponse> create_Artwork(@RequestBody CreateArtWorkRequest request){
        return ResponseEntity.ok(artWorkService.createArtwork(request));
      }

//    @GetMapping("/hello")
//    public String helloBackend() {
//        return "Hello World from the backend!";
//    }

}
