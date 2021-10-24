package com.example.thymeleafandvalidations.services;


import com.example.thymeleafandvalidations.models.entities.Company;
import com.example.thymeleafandvalidations.models.service.AddCompanyServiceModel;
import com.example.thymeleafandvalidations.models.view.CompanyView;

import java.util.List;

public interface CompanyService {
    void addCompany(AddCompanyServiceModel addCompanyServiceModel);
    boolean existByUsername(String username);

    List<CompanyView> getAll();

    CompanyView getById(Long id);

    void deleteById(Long id);

    Company getName(String company);
}
