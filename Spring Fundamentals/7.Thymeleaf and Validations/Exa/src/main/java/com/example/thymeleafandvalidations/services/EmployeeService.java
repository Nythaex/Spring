package com.example.thymeleafandvalidations.services;

import com.example.thymeleafandvalidations.models.service.AddEmployeeServiceModel;
import com.example.thymeleafandvalidations.models.view.EmployeeView;

import java.util.List;

public interface EmployeeService {
    List<EmployeeView> getAll();

    EmployeeView getById(Long id);

    void addEmployee(AddEmployeeServiceModel emp);

    void deleteById(Long id);
}
