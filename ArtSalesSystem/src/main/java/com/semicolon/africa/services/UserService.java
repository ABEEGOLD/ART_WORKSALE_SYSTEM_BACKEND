package com.semicolon.africa.services;

import com.semicolon.africa.dtos.requestUser.*;
import com.semicolon.africa.dtos.responseUser.*;

public interface UserService {

    RegisterUserResponse registerUser(RegisterUserRequest request);

    LoginUserResponse loginUser(LoginUserRequest requestLogin);

    UserProfileResponse getUserProfile(UserProfileRequest profRequest);

    ChangePasswordResponse changePassword(ChangePasswordRequest passwordRequest);

    GetUserAllArtWorksResponse getUserArtworks(GetUserAllArtWorksRequest requestGet);

    PurchaseArtWorkResponse purchaseArtwork(PurchaseArtWorkRequest purchaseRequest);

    DeleteUserResponse deleteUser(DeleteUserRequest delete);
}
