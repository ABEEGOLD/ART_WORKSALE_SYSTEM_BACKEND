package com.semicolon.africa.dtos.requestArtist;

import com.semicolon.africa.data.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestArtist {
    private Long userId;
    private String bio;
    private String website;
    private String profileImageUrl;
}
