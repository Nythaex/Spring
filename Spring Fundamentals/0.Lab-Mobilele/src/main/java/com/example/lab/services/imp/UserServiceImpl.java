package com.example.lab.services.imp;

import com.example.lab.models.binding.LoginBinding;
import com.example.lab.models.entity.User;
import com.example.lab.models.services.UserRegisterService;
import com.example.lab.repos.UserRepository;
import com.example.lab.services.UserService;
import com.example.lab.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
   private UserRepository userRepository;
   private CurrentUser currentUser;
   private ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;

    }

    @Override
    public boolean register(UserRegisterService userRegisterService) {

        if (userRepository.existsByUsername(userRegisterService.getUsername())){
            return false;
        }else {
            User user =modelMapper.map(userRegisterService,User.class);
            user.setCreated(LocalDateTime.now());
            user.setPassword(user.getPassword());
            userRepository.save(user);
        }
        return true;
    }

    @Override
    public boolean login(LoginBinding loginBinding) {
        User user=userRepository.findUserByUsername(loginBinding.getUsername());
        if (user!=null&&user.getPassword().equals(loginBinding.getPassword()))
        {
            currentUser.setUsername(user.getUsername()).setFirstName(user.getFirstName()).setLastName(user.getLastName()).setLoggedIn(true).setRole(user.getRole().getName().toString()).setId(user.getId());
            return true;
        }
        return false;
    }

    @Override
    public boolean logout() {
        currentUser.setUsername(null).setFirstName(null).setLastName(null).setLoggedIn(false).setRole(null);
        return true;
    }
}
