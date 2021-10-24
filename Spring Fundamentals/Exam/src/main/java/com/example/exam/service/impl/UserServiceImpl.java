package com.example.exam.service.impl;

import com.example.exam.CurrentUser;
import com.example.exam.model.binding.LoginBinding;
import com.example.exam.model.entity.User;
import com.example.exam.model.service.RegisterService;
import com.example.exam.repo.UserRepository;
import com.example.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   private UserRepository repository;
   private ModelMapper modelMapper;
   private CurrentUser currentUser;

    public UserServiceImpl(UserRepository repository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public boolean existByUsername(String value) {
        User user=repository.getByUsername(value);
        if (user==null){
            return true;
        }
        return false;
    }

    @Override
    public boolean existByEmail(String value) {
        User user=repository.getByEmail(value);
        if (user==null){
            return true;
        }
        return false;
    }

    @Override
    public void register(RegisterService map) {
        User map1 = modelMapper.map(map, User.class);

        repository.save(map1);
    }

    @Override
    public boolean login(LoginBinding loginBinding) {
        User byUsername = repository.getByUsername(loginBinding.getUsername());
        if (byUsername==null||(!byUsername.getPassword().equals(loginBinding.getPassword()))){
            return false;
        }
        currentUser.setId(byUsername.getId());
        return true;
    }

    @Override
    public User getAllById(Long id) {
      return   repository.getById(id);
    }

    @Override
    public User getUser(CurrentUser currentUser) {
       return repository.getById(currentUser.getId());

    }
}
