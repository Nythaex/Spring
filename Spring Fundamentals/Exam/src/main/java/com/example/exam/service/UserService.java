package com.example.exam.service;

import com.example.exam.CurrentUser;
import com.example.exam.model.binding.LoginBinding;
import com.example.exam.model.entity.User;
import com.example.exam.model.service.RegisterService;

public interface UserService {
    boolean existByUsername(String value);

    boolean existByEmail(String value);

    void register(RegisterService map);

   boolean login(LoginBinding loginBinding);


    User getAllById(Long id);

    User getUser(CurrentUser currentUser);
}

