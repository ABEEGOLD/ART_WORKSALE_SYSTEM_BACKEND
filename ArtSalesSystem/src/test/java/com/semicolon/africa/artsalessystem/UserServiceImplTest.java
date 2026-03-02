package com.semicolon.africa.artsalessystem;

import com.semicolon.africa.data.models.Role;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requestUser.LoginUserRequest;
import com.semicolon.africa.dtos.requestUser.RegisterUserRequest;
import com.semicolon.africa.dtos.requestUser.UserProfileRequest;
import com.semicolon.africa.dtos.responseUser.LoginUserResponse;
import com.semicolon.africa.dtos.responseUser.RegisterUserResponse;
import com.semicolon.africa.dtos.responseUser.UserProfileResponse;
import com.semicolon.africa.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserServiceImplTest {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void setUp() {
        userRepository.deleteAll();
    }



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
      assertThat(loginResponse.getRole()).isEqualTo(Role.BUYER);
      assertThat(loginResponse.getName()).isEqualTo("John Wick");

  }

  @Test
    public void testThatUserCanGetUserProfile(){
      User user = new User();
      user.setName("John Wick");
      user.setEmail("john@gmail.com");
      user.setPassword("password");
      user.setRole(Role.BUYER);

      user = userRepository.save(user);

      UserProfileRequest userProfileRequest = new UserProfileRequest();
      userProfileRequest.setUserId(user.getId());

      UserProfileResponse userProfileResponse = userService.getUserProfile(userProfileRequest);
      assertThat(userProfileResponse).isNotNull();
      assertThat(userProfileResponse.getMessage()).isEqualTo("User profile retrieved successfully");
      assertThat(userProfileResponse.getName()).isEqualTo("John Wick");
      assertThat(userProfileResponse.getEmail()).isEqualTo("john@gmail.com");
      assertThat(userProfileResponse.getProfilePictureUrl()).isEqualTo("photo.jpg");

    }
}
