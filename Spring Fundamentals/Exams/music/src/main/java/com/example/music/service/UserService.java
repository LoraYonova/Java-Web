package com.example.music.service;

import com.example.music.model.entity.UserEntity;
import com.example.music.model.service.UserServiceModel;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserEntity findById(Long id);

    void loginUser(Long id, String username);
}
