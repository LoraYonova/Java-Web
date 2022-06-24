package com.example.gira.service.impl;

import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.service.UserServiceModel;
import com.example.gira.repository.UserRepository;
import com.example.gira.service.UserService;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
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
    public UserServiceModel findByEmailAndPassword(String email, String password) {

        return userRepository.findByEmailAndPassword(email, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public UserEntity findById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void loginUser(Long id, String email) {
        currentUser.setId(id).setEmil(email);
    }
}
