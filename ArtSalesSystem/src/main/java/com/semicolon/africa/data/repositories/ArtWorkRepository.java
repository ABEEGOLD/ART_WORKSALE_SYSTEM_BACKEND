package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.ArtWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ArtWorkRepository extends JpaRepository<ArtWork,Long> {

    List<ArtWork> findByArtistId(Long id);

}
