package com.example.thymeleafandvalidations.web;

import com.example.thymeleafandvalidations.models.binding.AddEmployeeBinding;
import com.example.thymeleafandvalidations.models.service.AddEmployeeServiceModel;
import com.example.thymeleafandvalidations.models.view.CompanyView;
import com.example.thymeleafandvalidations.services.CompanyService;
import com.example.thymeleafandvalidations.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {
    private ModelMapper modelMapper;
    private EmployeeService employeeService;
    private CompanyService companyService;

    public EmployeeController(ModelMapper modelMapper, EmployeeService employeeService, CompanyService companyService) {
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @ModelAttribute
    public AddEmployeeBinding addEmployeeBinding() {
        return new AddEmployeeBinding();
    }

    @GetMapping("/employees/add")
    public String getAddEmployee(Model model) {
        if (!model.containsAttribute("isLevelNull")){
            model.addAttribute("isLevelNull",false);
        }
          model.addAttribute("companies",companyService.getAll().stream().map(CompanyView::getName).collect(Collectors.toList()));
        return "employee-add";
    }

    @PostMapping("/employees/add")
    public String postAddEmployee(@Valid AddEmployeeBinding addEmployeeBinding, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            if (addEmployeeBinding.getEducationLevel() == null) {
                redirectAttributes.addFlashAttribute("isLevelNull", true);
            }
            redirectAttributes.addFlashAttribute("addEmployeeBinding", addEmployeeBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addEmployeeBinding", bindingResult);
            return "redirect:/employees/add";
        }

        AddEmployeeServiceModel emp = modelMapper.map(addEmployeeBinding, AddEmployeeServiceModel.class);
        emp.setCompany(companyService.getName(addEmployeeBinding.getCompany()));
        employeeService.addEmployee(emp);

        return "redirect:/employees/all";
    }


    @GetMapping("/employees/all")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "employee-all";
    }

    @GetMapping("/employees/all/{id}")
    public String getDetails(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "employee-details";
    }

    @DeleteMapping("/employees/all/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "employee-all";
    }


}
