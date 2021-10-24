package com.example.lab.web;

import com.example.lab.models.binding.LoginBinding;
import com.example.lab.services.UserService;
import com.example.lab.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserLoginLogoutController {
    private static Logger logger;

    private UserService userService;

    public UserLoginLogoutController( UserService userService) {
        this.userService = userService;

        this.logger = LoggerFactory.getLogger(UserLoginLogoutController.class);

    }
    @ModelAttribute()
    public LoginBinding loginBinding(){
        return new LoginBinding();
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        if (!model.containsAttribute("isLoggedIn")){
            model.addAttribute("isLoggedIn",true);
        }


        return "auth-login";
    }


    @PostMapping("/login")
    public String login(LoginBinding loginBinding, RedirectAttributes redirectAttributes) {
        boolean login = userService.login(loginBinding);
        if (login) {
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("loginBinding",loginBinding);
        redirectAttributes.addFlashAttribute("isLoggedIn",false);


        return "redirect:login";
    }



    @GetMapping("logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();

        return "redirect:/";
    }
}


