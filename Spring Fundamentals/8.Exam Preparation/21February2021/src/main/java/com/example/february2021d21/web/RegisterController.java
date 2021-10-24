package com.example.february2021d21.web;

import com.example.february2021d21.model.binding.RegisterBinding;
import com.example.february2021d21.model.service.RegisterService;
import com.example.february2021d21.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegisterController {
    private UserService userService;
    private ModelMapper modelMapper;

    public RegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @ModelAttribute
    public RegisterBinding registerBinding(){
        return new RegisterBinding();
    }

    @GetMapping("/home/register")
    public String getRegister(Model model){

        return "register";
    }

    @PostMapping("/home/register")
    public String postRegister(@Valid RegisterBinding registerBinding, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()||!registerBinding.getPassword().equals(registerBinding.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("registerBinding",registerBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerBinding",bindingResult);


            return "redirect:/home/register";
        }
        userService.register(modelMapper.map(registerBinding, RegisterService.class));

        return "redirect:/home/login";
    }

}
