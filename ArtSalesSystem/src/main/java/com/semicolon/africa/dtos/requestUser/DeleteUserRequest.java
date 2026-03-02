package com.semicolon.africa.dtos.requestUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteUserRequest {
    private Long userId;
    private String name;
    private String email;
}
