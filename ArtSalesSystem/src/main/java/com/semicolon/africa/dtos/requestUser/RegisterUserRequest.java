package com.semicolon.africa.dtos.requestUser;

import com.semicolon.africa.data.models.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {
    private Long id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.BUYER;
}
