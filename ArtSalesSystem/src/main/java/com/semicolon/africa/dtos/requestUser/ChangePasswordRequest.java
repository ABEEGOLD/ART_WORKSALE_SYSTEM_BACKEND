package com.semicolon.africa.dtos.requestUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordRequest {
    private Long userId;
    private String oldPassword;
    private String newPassword;
}
