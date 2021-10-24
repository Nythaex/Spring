package com.example.lab.repos;

import com.example.lab.models.entity.Enums.Role;
import com.example.lab.models.entity.User;
import com.example.lab.models.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    UserRole getByName(Role name);
}
