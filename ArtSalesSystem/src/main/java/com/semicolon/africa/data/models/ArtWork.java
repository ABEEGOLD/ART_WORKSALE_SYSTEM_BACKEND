package com.semicolon.africa.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ArtWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 1000)
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private StatusArtwork status = StatusArtwork.AVAILABLE;

    private LocalDateTime createdDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;


//    @Override
//    public String toString(){
//        return "ArtWork{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", price=" + price +
//                ", status=" + status +
//                '}';
//
//    }

}
