package com.example.exam.web;

import com.example.exam.CurrentUser;
import com.example.exam.model.binding.LoginBinding;
import com.example.exam.service.UserService;
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
    private ModelMapper modelMapper;
    private UserService userService;
    private CurrentUser currentUser;

    public LoginController(ModelMapper modelMapper, UserService userService, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
    }


    @ModelAttribute
    public LoginBinding loginBinding(){
        return new LoginBinding();
    }

    @GetMapping("/home/login")
    public String getLogin(Model model){

        if (currentUser.getId()!=null){
            return "home";
        }

        if (!model.containsAttribute("match")){
            model.addAttribute("match",true);
        }

        return "login";
    }


    @PostMapping("/home/login")
    public String postLogin(@Valid LoginBinding loginBinding, BindingResult bindingResult, RedirectAttributes redirectAttributes){



        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginBinding",loginBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginBinding",bindingResult);

            return "redirect:/home/login";
        }

        boolean login = userService.login(loginBinding);
        if (!login){
            redirectAttributes.addFlashAttribute("match",false);
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
