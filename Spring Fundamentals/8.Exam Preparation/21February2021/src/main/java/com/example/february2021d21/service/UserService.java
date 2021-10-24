package com.example.february2021d21.service;

import com.example.february2021d21.model.binding.LoginBinding;
import com.example.february2021d21.model.entity.User;
import com.example.february2021d21.model.service.RegisterService;

public interface UserService {
    void register(RegisterService map);



    boolean login(LoginBinding loginBinding);

    User getById(Long id);



    boolean existByUsername(String value);

    boolean existByEmail(String value);
}
