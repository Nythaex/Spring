package com.example.lab.services;

import com.example.lab.models.entity.Brand;
import com.example.lab.models.entity.Models;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelService {
    List<Models> getAllByBrand(Brand brand);

    Object getAll();
}
