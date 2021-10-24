package com.example.exam.web;

import com.example.exam.CurrentUser;
import com.example.exam.model.binding.AddShipBinding;
import com.example.exam.model.entity.Ship;
import com.example.exam.service.CategoryService;
import com.example.exam.service.ShipService;
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
public class ShipController {
    private CurrentUser currentUser;
    private ModelMapper modelMapper;
    private CategoryService categoryService;
    private ShipService shipService;
    private UserService userService;
    public ShipController(CurrentUser currentUser, ModelMapper modelMapper, CategoryService categoryService, ShipService shipService, UserService userService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.shipService=shipService;
        this.userService = userService;
    }

    @ModelAttribute()
    public AddShipBinding addShipBinding(){
        return new AddShipBinding();
    }

    @GetMapping("/home/add")
    public String getAddShips(Model model){
        if (currentUser.getId()==null){
            return "login";
        }
       model.addAttribute("ships",categoryService.getAll());



        return "ship-add";
    }
    @PostMapping("/home/add")
    public String postAddShip(@Valid AddShipBinding addShipBinding, BindingResult bindingResult, RedirectAttributes redirectAttributes){



        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addShipBinding",addShipBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addShipBinding",bindingResult);

            return "redirect:/home/add";
        }
        Ship ship = modelMapper.map(addShipBinding, Ship.class);
         ship.setCategory(categoryService.getByName(addShipBinding.getCategory()));
        ship.setUser(userService.getUser(currentUser));
        shipService.addShip(modelMapper.map(ship, Ship.class));




        return "redirect:/home";
    }
}
