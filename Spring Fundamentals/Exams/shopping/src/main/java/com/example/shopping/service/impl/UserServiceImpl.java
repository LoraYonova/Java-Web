package com.example.shopping.service.impl;

import com.example.shopping.model.entity.UserEntity;
import com.example.shopping.model.service.UserServiceModel;
import com.example.shopping.repository.UserRepository;
import com.example.shopping.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
      try {
          userRepository.save(modelMapper.map(userServiceModel, UserEntity.class));
      } catch (Exception e) {
          return false;
      }

        return true;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);


    }


}
