package com.semicolon.africa.dtos.requestUser;

import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;

@Getter
@Setter
public class  LoginUserRequest {
private String email;
private String name;
private String password;
private Role role;
}
