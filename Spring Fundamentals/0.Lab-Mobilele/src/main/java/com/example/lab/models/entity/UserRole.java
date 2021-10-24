package com.example.lab.models.entity;

import com.example.lab.models.entity.Enums.Role;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRole extends BasicEntity {
    @Enumerated(EnumType.STRING)
    private Role name;

    public UserRole() {

    }

    public UserRole(Role name) {
        this.name = name;
    }

    public Role getName() {
        return name;
    }

    public UserRole setName(Role name) {
        this.name = name;
        return this;
    }
}
