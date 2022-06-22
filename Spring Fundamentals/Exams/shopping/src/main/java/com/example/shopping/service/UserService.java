package com.example.shopping.service;

import com.example.shopping.model.service.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);


}
