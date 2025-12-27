package com.semicolon.africa.artsalessystem;

import com.semicolon.africa.data.models.Role;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requestUser.LoginUserRequest;
import com.semicolon.africa.dtos.requestUser.RegisterUserRequest;
import com.semicolon.africa.dtos.responseUser.LoginUserResponse;
import com.semicolon.africa.dtos.responseUser.RegisterUserResponse;
import com.semicolon.africa.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceImplTest {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;




  @Test
  public void testThatUserCanBeRegister(){
      RegisterUserRequest req = getUserRegistered();
      RegisterUserResponse response = userService.registerUser(req);

      assertThat(response).isNotNull();
      assertThat(response.getMessage()).isEqualTo("User created successfully");
      assertThat(response.getArtType());


  }

  public RegisterUserRequest getUserRegistered(){
      RegisterUserRequest registerUserRequest = new RegisterUserRequest();
      registerUserRequest.setName("John Wick");
      registerUserRequest.setEmail("john" + System.currentTimeMillis() + "@gmail.com");
      registerUserRequest.setPassword("passwordEncode");
      registerUserRequest.setRole(Role.BUYER);
      return registerUserRequest;
  }

  @Test
  public void testThatUserCanBeLogin(){
      LoginUserRequest loginRequest = new LoginUserRequest();
      loginRequest.setPassword("passwordEncode");
      loginRequest.setEmail("john@gmail.com");

      LoginUserResponse  loginResponse = userService.loginUser(loginRequest);

      assertThat(loginResponse).isNotNull();
      assertThat(loginResponse.getMessage()).isEqualTo("User login successful");
      assertThat(loginResponse.getRole());
      assertThat(loginResponse.getName()).isEqualTo("John Wick");

  }

  @Test
    public void testThatUserCanBeLogout(){

    }
}
