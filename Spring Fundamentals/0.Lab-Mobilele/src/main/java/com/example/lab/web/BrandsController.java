package com.example.lab.web;

import com.example.lab.models.view.BrandView;
import com.example.lab.services.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BrandsController {
    private BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("brands/all")
    public ModelAndView getBrands(ModelAndView modelAndView){

        List<BrandView> allBrands = brandService.getAllBrands();

        modelAndView.addObject("brands",allBrands);
        modelAndView.setViewName("brands");
        return modelAndView;
    }
}
