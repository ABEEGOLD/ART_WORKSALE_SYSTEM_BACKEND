package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.ArtWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtWorkRepository extends JpaRepository<ArtWork,Long> {
    List<ArtWork> findAllById(Long id);
}
