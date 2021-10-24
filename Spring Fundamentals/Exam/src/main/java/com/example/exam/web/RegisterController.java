package com.example.exam.web;

import com.example.exam.CurrentUser;
import com.example.exam.model.binding.RegisterBinding;
import com.example.exam.model.service.RegisterService;
import com.example.exam.service.UserService;
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
    private CurrentUser currentUser;

    public RegisterController(UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public RegisterBinding registerBinding(){
        return new RegisterBinding();
    }

    @GetMapping("/home/register")
    public String getRegister(Model model){
        if (currentUser.getId()!=null){
            return "home";
        }

        return "register";
    }


    @PostMapping("/home/register")
    public String postRegister(@Valid RegisterBinding registerBinding, BindingResult bindingResult, RedirectAttributes redirectAttributes){



        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerBinding",registerBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerBinding",bindingResult);

            return "redirect:/home/register";
        }
        if (!registerBinding.getPassword().equals(registerBinding.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("registerBinding",registerBinding);
            return "redirect:/home/register";
        }
        RegisterService map = modelMapper.map(registerBinding, RegisterService.class);
        userService.register(map);

        return "redirect:/home/login";
    }
}
