package com.example.thymeleafandvalidations.services.impl;

import com.example.thymeleafandvalidations.models.entities.Employee;
import com.example.thymeleafandvalidations.models.service.AddEmployeeServiceModel;
import com.example.thymeleafandvalidations.models.view.EmployeeView;
import com.example.thymeleafandvalidations.repos.EmployeeRepository;
import com.example.thymeleafandvalidations.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeView> getAll() {
        return employeeRepository.findAll().stream().map(s -> modelMapper.map(s, EmployeeView.class)).collect(Collectors.toList());

    }

    @Override
    public EmployeeView getById(Long id) {


        EmployeeView map = modelMapper.map(employeeRepository.getById(id), EmployeeView.class);
        map.setCompany(employeeRepository.getById(id).getCompany().getName());
        return map;
    }

    @Override
    public void addEmployee(AddEmployeeServiceModel emp) {
        employeeRepository.save(modelMapper.map(emp, Employee.class));
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
