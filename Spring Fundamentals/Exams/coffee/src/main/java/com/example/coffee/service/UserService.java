package com.example.coffee.service;

import com.example.coffee.model.entity.UserEntity;
import com.example.coffee.model.service.UserServiceModel;
import com.example.coffee.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    UserEntity findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrderByCountDesc();
}
