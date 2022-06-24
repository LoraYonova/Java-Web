package com.example.gira.service;

import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.service.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByEmailAndPassword(String email, String password);

    UserEntity findById(Long id);

    void loginUser(Long id, String email);
}
