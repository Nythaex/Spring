package com.example.lab.services;

import com.example.lab.models.view.BrandView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<BrandView> getAllBrands();
}
