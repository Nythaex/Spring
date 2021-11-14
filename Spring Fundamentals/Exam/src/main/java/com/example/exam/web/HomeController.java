package com.example.exam.web;

import com.example.exam.CurrentUser;
import com.example.exam.model.entity.Ship;
import com.example.exam.model.view.ViewShip;
import com.example.exam.service.ShipService;
import com.example.exam.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private CurrentUser currentUser;
    private UserService userService;
    private ShipService shipService;

    public HomeController(CurrentUser currentUser, UserService userService, ShipService shipService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.shipService = shipService;
    }


    @GetMapping("/home")
    public String getHome(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        Map<String,List<ViewShip>> all=shipService.getAll(currentUser);

        model.addAttribute("my", all.get("my"));
        model.addAttribute("allInsteadOf", all.get("enemy"));
        model.addAttribute("all", all.get("all"));
        model.addAttribute("zero",0);

        return "home";
    }

    @PostMapping("/home")
    public String postHome(@RequestParam Long my, @RequestParam Long allInsteadOf) {
          if (my==0||allInsteadOf==0){
              return "redirect:/home";
          }

        shipService.fight(my, allInsteadOf);

        return "redirect:/home";
    }



    @GetMapping("")
    public String getIndex(Model model) {
        if (currentUser.getId() != null) {
            return "home";
        }
        return "index";
    }





}
