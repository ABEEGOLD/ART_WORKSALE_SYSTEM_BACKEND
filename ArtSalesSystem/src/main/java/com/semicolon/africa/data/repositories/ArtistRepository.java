package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.ArtWork;
import com.semicolon.africa.data.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist,Long> {


    Optional<Artist> findByUserId(Long userId);

}
