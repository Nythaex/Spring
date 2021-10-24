package com.example.lab.services;

import com.example.lab.models.entity.Enums.Role;
import com.example.lab.models.entity.UserRole;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {

    public UserRole findByRole(Role role);
}
