package com.semicolon.africa.dtos.responseUser;

import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;

@Getter
@Setter
public class LoginUserResponse {
    private Long userId;
    private String message;
    private String name;
    private Role role;
}
