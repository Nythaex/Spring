package com.example.coockie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CoockieContr {

    @GetMapping("/")
    public ModelAndView getHome( ModelAndView modelAndView,@CookieValue(name = "langCookie",defaultValue = "en") String lang){
        modelAndView.addObject("htmlLang",lang);
      modelAndView.setViewName("home");
      return modelAndView;
    }
    @PostMapping("/")
    public String getHome(HttpServletResponse httpServletResponse, @RequestParam(name = "requestLanguage") String lang){
     Cookie cookie=new Cookie("langCookie",lang);
        httpServletResponse.addCookie(cookie);
        return "redirect:/";
    }
}

