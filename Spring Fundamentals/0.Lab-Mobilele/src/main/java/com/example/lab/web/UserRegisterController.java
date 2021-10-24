package com.example.lab.web;

import com.example.lab.models.binding.RegisterBinding;
import com.example.lab.models.services.UserRegisterService;
import com.example.lab.services.UserRoleService;
import com.example.lab.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserRegisterController {
    private UserService userService;
    private ModelMapper modelMapper;
    private UserRoleService userRoleService;

    public UserRegisterController(UserService userService, ModelMapper modelMapper, UserRoleService userRoleService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userRoleService = userRoleService;
    }

    @ModelAttribute
    public RegisterBinding registerBinding() {
        return new RegisterBinding();
    }

    @GetMapping("/users/register")
    public ModelAndView getRegister(ModelAndView modelAndView) {

        modelAndView.setViewName("auth-register");
        return modelAndView;
    }

    @PostMapping("/users/register")
    public String register(@Valid RegisterBinding registerBinding, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerBinding", registerBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerBinding", bindingResult);
            return "redirect:/users/register";

        }


        UserRegisterService userRegisterService = modelMapper.map(registerBinding, UserRegisterService.class);
        userRegisterService.setUserRole(userRoleService.findByRole(registerBinding.getUserRole()));

        boolean register = userService.register(userRegisterService);
        if (!register) {
            return "redirect:register";
        }
        return "redirect:login";
    }

}
