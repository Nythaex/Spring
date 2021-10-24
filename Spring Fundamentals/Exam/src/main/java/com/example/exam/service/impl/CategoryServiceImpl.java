package com.example.exam.service.impl;

import com.example.exam.model.entity.Category;
import com.example.exam.repo.CategoryRepository;
import com.example.exam.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void init() {
        if(categoryRepository.count()==0){
            categoryRepository.save(new Category().setName("BATTLE"));
            categoryRepository.save(new Category().setName("CARGO"));
            categoryRepository.save(new Category().setName("PATROL"));
        }


    }

    @Override
    public List<String> getAll() {
        return  categoryRepository.findAll().stream().map(Category::getName).collect(Collectors.toList());

    }

    @Override
    public Category getByName(String category) {
        return categoryRepository.getByName(category);
    }
}
