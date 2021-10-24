package com.example.february2021d21.service.impl;

import com.example.february2021d21.CurrentUser;
import com.example.february2021d21.model.binding.LoginBinding;
import com.example.february2021d21.model.entity.User;
import com.example.february2021d21.model.service.RegisterService;
import com.example.february2021d21.repo.UserRepository;
import com.example.february2021d21.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void register(RegisterService map) {
        userRepository.save(modelMapper.map(map, User.class));
    }

    @Override
    public boolean login(LoginBinding loginBinding) {
        User byUsername = userRepository.findByUsername(loginBinding.getUsername());
        if (byUsername == null) {
            return false;
        }

        if (byUsername.getPassword().equals(loginBinding.getPassword())) {
            currentUser.setUsername(byUsername.getUsername());
            currentUser.setId(byUsername.getId());
            return true;
        }
        return false;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public boolean existByUsername(String value) {
        User byUsername = userRepository.findByUsername(value);
        if (byUsername==null){
            return true;
        }
        return false;
    }

    @Override
    public boolean existByEmail(String value) {
        User byEmail = userRepository.findByEmail(value);
        return byEmail == null;
    }
}
