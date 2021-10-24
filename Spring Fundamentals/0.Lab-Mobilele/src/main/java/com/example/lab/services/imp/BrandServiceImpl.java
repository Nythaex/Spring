package com.example.lab.services.imp;

import com.example.lab.models.entity.Models;
import com.example.lab.models.view.BrandView;
import com.example.lab.models.view.ModelView;
import com.example.lab.repos.BrandRepository;
import com.example.lab.services.BrandService;
import com.example.lab.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private BrandRepository brandRepository;
    private ModelService modelService;
    private ModelMapper modelMapper;


    public BrandServiceImpl(BrandRepository brandRepository, ModelService modelService, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandView> getAllBrands() {
        List<BrandView> brands = new ArrayList<>();
        brandRepository.findAll().forEach(b -> {


            List<ModelView> allByBrand = modelService.getAllByBrand(b).stream().map(s -> modelMapper.map(s, ModelView.class)).collect(Collectors.toList());

            BrandView brandView = new BrandView(b.getName(), allByBrand);
            brands.add(brandView);
        });

        return brands;
    }
}
