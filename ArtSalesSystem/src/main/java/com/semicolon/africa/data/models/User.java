package com.semicolon.africa.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {
    @jakarta.persistence.Id
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String userName;
private String email;
private String password;
private String role;


}
