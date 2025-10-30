package com.semicolon.africa.controllers;

import com.semicolon.africa.dtos.requests.ArtWorkRequest;
import com.semicolon.africa.dtos.response.ArtWorkResponse;
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
    public ResponseEntity<ArtWorkResponse> create_Artwork(@RequestBody ArtWorkRequest request){
        return ResponseEntity.ok(artWorkService.createArtwork(request));
      }

//    @GetMapping("/hello")
//    public String helloBackend() {
//        return "Hello World from the backend!";
//    }

}
