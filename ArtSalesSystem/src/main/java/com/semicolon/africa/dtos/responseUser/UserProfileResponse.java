package com.semicolon.africa.dtos.responseUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileResponse {
    private String message;
    private String name;
    private String email;
    private String profilePictureUrl;
}
