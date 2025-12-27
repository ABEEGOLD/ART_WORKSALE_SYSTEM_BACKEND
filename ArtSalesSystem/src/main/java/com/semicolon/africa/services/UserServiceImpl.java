package com.semicolon.africa.services;

import com.semicolon.africa.data.models.*;
import com.semicolon.africa.data.repositories.ArtWorkRepository;
import com.semicolon.africa.data.repositories.ArtistRepository;
import com.semicolon.africa.data.repositories.PurchaseRepository;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requestUser.*;
import com.semicolon.africa.dtos.responseUser.*;
import com.semicolon.africa.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private ArtWorkRepository artWorkRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request)  {
        if (userRepository.findUsersByEmail(request.getEmail()) != null) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("User created successfully");
        return response;
    }


    @Override
    public LoginUserResponse loginUser(LoginUserRequest requestLogin)  {

        User user = userRepository.findUsersByEmail(requestLogin.getEmail());
        if(user == null){
            throw new UserNotFoundException("Invalid email or password");
        }

        if (!passwordEncoder.matches(requestLogin.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }

        LoginUserResponse response = new LoginUserResponse();
        response.setMessage("User login successful");
        response.setRole(response.getRole());
        response.setName(user.getName());
        return response;
    }

    @Override
    public UserProfileResponse getUserProfile(UserProfileRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        UserProfileResponse response = new UserProfileResponse();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setProfilePictureUrl("photo.jpg");
        response.setMessage("User profile retrieved successfully");

        return response;
    }

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordRequest passwordRequest){
        User user = userRepository.findById(passwordRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(passwordRequest.getOldPassword(), user.getPassword())) {
            throw new UserUpdateOldPasswordException("Invalid old password");

        }

        user.setPassword(passwordEncoder.encode(passwordRequest.getNewPassword()));
        userRepository.save(user);

        ChangePasswordResponse response = new ChangePasswordResponse();
        response.setMessage("Password changed successfully");
        return response;

    }

    @Override
    public GetUserAllArtWorksResponse getUserArtworks(GetUserAllArtWorksRequest requestGet){
        userRepository.findById(requestGet.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Artist artist = artistRepository.findByUserId(requestGet.getUserId())
                .orElseThrow(() -> new ArtistNotFoundException("Artist not found"));

        List<ArtWork> artworks = artWorkRepository.findByArtistId(artist.getId());

        GetUserAllArtWorksResponse response = new GetUserAllArtWorksResponse();
        response.setMessage("All User Artwork Retrieved Successfully");
        response.setArtwork(artworks);
        return response;
    }

    @Override
    public PurchaseArtWorkResponse purchaseArtwork(PurchaseArtWorkRequest purchaseRequest) {
        User buyer = userRepository.findById(purchaseRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        ArtWork artwork = artWorkRepository.findById(purchaseRequest.getArtworkId())
                .orElseThrow(() -> new ArtworkNotFoundException("Artwork not found"));

        if (artwork.getStatus() != StatusArtwork.AVAILABLE) {
            throw new ArtworkNotAvailableException("Artwork already been purchased");
        }

        if (artwork.getArtist().getId().equals(buyer.getId())) {
            throw new UserNotAllowedException("You cannot buy your own artwork");
        }

        if (!buyer.getRole().equals(Role.BUYER)) {
            throw new UserNotAllowedException("Only users can purchase artwork");
        }


        artwork.setStatus(StatusArtwork.SOLD);
        artWorkRepository.save(artwork);

        Purchase purchase = new Purchase();
        purchase.setArtwork(artwork);
        purchase.setBuyer(buyer);
        purchase.setPricePaid(artwork.getPrice());
        purchase.setPurchaseDate(LocalDateTime.now());
        purchase.setStatus(PurchaseStatus.COMPLETED);

        purchaseRepository.save(purchase);

        PurchaseArtWorkResponse response = new PurchaseArtWorkResponse();
        response.setMessage("Purchase Completed Successfully");
        response.setArtworkTitle(artwork.getTitle());
        response.setPrice(artwork.getPrice());
        response.setStatus(PurchaseStatus.COMPLETED);
        response.setPurchaseDate(purchase.getPurchaseDate());

        return response;
    }

    @Override
    public DeleteUserResponse deleteUser(DeleteUserRequest delete){
        User user = userRepository.findById(delete.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        userRepository.delete(user);

        DeleteUserResponse response = new DeleteUserResponse();
        response.setMessage("User deleted Successfully");

        return response;

    }



//@Override
//    public LoginUserResponse loginUser(LoginUserRequest requestLogin) {
//    User use = userRepository.findUserByPassword(requestLogin.getPassword());
//    if (use==null){
//        throw new UserNotFoundException("User Not found");
//    }
//
//    use.setPassword(requestLogin.getPassword());
//    use.setEmail(requestLogin.getEmail());
//    User loginUserSaved = userRepository.save(use);
//
//    LoginUserResponse response = new LoginUserResponse();
//    response.setMessage(" User Login Successfully");
//    return response;
//
//}

}
