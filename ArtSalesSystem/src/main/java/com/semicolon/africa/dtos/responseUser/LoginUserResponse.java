package com.semicolon.africa.dtos.responseUser;

import com.semicolon.africa.data.models.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LoginUserResponse {
    private Long userId;
    private String message;
    private String name;
    private Role role;
}
