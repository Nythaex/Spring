package com.example.thymeleafandvalidations.services.impl;

import com.example.thymeleafandvalidations.models.entities.Company;
import com.example.thymeleafandvalidations.models.service.AddCompanyServiceModel;
import com.example.thymeleafandvalidations.models.view.CompanyView;
import com.example.thymeleafandvalidations.repos.CompanyRepository;
import com.example.thymeleafandvalidations.services.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCompany(AddCompanyServiceModel addCompanyServiceModel) {
        companyRepository.save(modelMapper.map(addCompanyServiceModel, Company.class));
    }

    @Override
    public boolean existByUsername(String username) {
        Company byName = companyRepository.findByName(username);
        if (byName!=null){
            return false;
        }
        return true;
    }

    @Override
    public List<CompanyView> getAll() {
        return  companyRepository.findAll().stream().map(s->modelMapper.map(s,CompanyView.class)).collect(Collectors.toList());
    }

    @Override
    public CompanyView getById(Long id) {
       return modelMapper.map(companyRepository.getById(id),CompanyView.class);

    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company getName(String company) {
        return companyRepository.findByName(company);
    }
}
