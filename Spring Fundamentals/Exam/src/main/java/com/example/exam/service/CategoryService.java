package com.example.exam.service;

import com.example.exam.model.entity.Category;

import java.util.List;

public interface CategoryService {
    void init();

    List<String> getAll();

    Category getByName(String category);
}
