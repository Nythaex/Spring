package com.example.lab.services.imp;

import com.example.lab.models.entity.Enums.Role;
import com.example.lab.models.entity.UserRole;
import com.example.lab.repos.UserRoleRepository;
import com.example.lab.services.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole findByRole(Role role) {
        UserRole byName = userRoleRepository.getByName(role);
        return byName;
    }
}
