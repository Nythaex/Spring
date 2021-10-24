package com.example.thymeleafandvalidations.web;

import com.example.thymeleafandvalidations.models.binding.AddCompanyBinding;
import com.example.thymeleafandvalidations.models.service.AddCompanyServiceModel;
import com.example.thymeleafandvalidations.services.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CompanyController {
    private ModelMapper modelMapper;
    private CompanyService companyService;

    public CompanyController(ModelMapper modelMapper, CompanyService companyService) {
        this.modelMapper = modelMapper;
        this.companyService = companyService;
    }

    @ModelAttribute
    public AddCompanyBinding addCompanyBinding() {
        return new AddCompanyBinding();
    }

    @GetMapping("/companies/add")
    public ModelAndView getAddCompanies(ModelAndView modelAndView) {


        modelAndView.setViewName("company-add");
        return modelAndView;
    }

    @PostMapping("/companies/add")
    public String postAddCompanies(@Valid AddCompanyBinding addCompanyBinding, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addCompanyBinding", addCompanyBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addCompanyBinding", bindingResult);
            return "redirect:/companies/add";
        }
        AddCompanyServiceModel company = modelMapper.map(addCompanyBinding, AddCompanyServiceModel.class);
        companyService.addCompany(company);
        return "redirect:/";
    }


    @GetMapping("/companies/all")
    public ModelAndView getAllCompanies(ModelAndView modelAndView) {


        modelAndView.addObject("companies", companyService.getAll());
        modelAndView.setViewName("company-all");
        return modelAndView;
    }

    @GetMapping("/companies/all/{id}")
    public String getDetails(@PathVariable Long id, Model model){
       model.addAttribute("companyView",companyService.getById(id));
        return "company-details";
    }

    @DeleteMapping("/companies/all/{id}")
    public String deleteCompany(@PathVariable Long id){
        companyService.deleteById(id);
        return "redirect:/companies/all";
    }

}
