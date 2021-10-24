package com.example.lab.services;

import com.example.lab.models.binding.LoginBinding;
import com.example.lab.models.binding.RegisterBinding;
import com.example.lab.models.services.UserRegisterService;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public boolean register(UserRegisterService userRegisterService);
    public boolean login(LoginBinding loginBinding);

    boolean logout();
}
