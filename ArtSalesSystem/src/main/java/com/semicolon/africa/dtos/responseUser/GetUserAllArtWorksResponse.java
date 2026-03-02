package com.semicolon.africa.dtos.responseUser;

import com.semicolon.africa.data.models.ArtWork;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class GetUserAllArtWorksResponse {
    private List<ArtWork> artwork;
    private String message;
}
