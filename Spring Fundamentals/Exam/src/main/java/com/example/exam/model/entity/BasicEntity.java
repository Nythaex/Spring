package com.example.exam.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BasicEntity {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public BasicEntity(Long id) {
        Id = id;
    }

    public BasicEntity() {
    }

    public Long getId() {
        return Id;
    }

    public BasicEntity setId(Long id) {
        Id = id;
        return this;
    }
}
