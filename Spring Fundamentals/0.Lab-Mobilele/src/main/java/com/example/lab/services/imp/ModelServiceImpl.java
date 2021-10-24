package com.example.lab.services.imp;

import com.example.lab.models.entity.Brand;
import com.example.lab.models.entity.Models;
import com.example.lab.repos.ModelRepository;
import com.example.lab.services.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<Models> getAllByBrand(Brand brand) {
        modelRepository.findAllByBrand(brand);

        return modelRepository.findAllByBrand(brand);
    }
}
