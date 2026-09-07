package com.semicolon.africa.dtos.respondArtist;

import com.semicolon.africa.data.models.Artist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespondArtist {
    private String message;
    private Artist artist;
}
