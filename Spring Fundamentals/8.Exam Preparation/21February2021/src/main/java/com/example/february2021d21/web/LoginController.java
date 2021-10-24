package com.example.february2021d21.web;

import com.example.february2021d21.CurrentUser;
import com.example.february2021d21.model.binding.LoginBinding;
import com.example.february2021d21.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {
    private UserService userService;
    private ModelMapper modelMapper;
    private CurrentUser currentUser;

    public LoginController(UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public LoginBinding registerBinding(){
        return new LoginBinding();
    }

    @GetMapping("/home/login")
    public String getLogin(Model model){
        if (!model.containsAttribute("match")){
            model.addAttribute("match",false);
        }

        return "login";
    }

    @PostMapping("/home/login")
    public String postLogin(@Valid LoginBinding loginBinding,BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginBinding",loginBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginBinding",bindingResult);
            return "redirect:/home/login";
        }
        boolean login = userService.login(loginBinding);
        if (!login){
            redirectAttributes.addFlashAttribute("match",true);
            return "redirect:/home/login";
        }

        return "redirect:/home";
    }
    @GetMapping("/home/logut")
    public String getLogout(Model model, HttpSession httpSession){
        httpSession.invalidate();

        return "index";
    }
}
