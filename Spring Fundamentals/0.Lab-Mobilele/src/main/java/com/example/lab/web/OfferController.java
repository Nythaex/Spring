package com.example.lab.web;

import com.example.lab.models.binding.AddOfferBinding;
import com.example.lab.models.entity.Enums.Engine;
import com.example.lab.models.entity.Enums.Transmission;
import com.example.lab.models.view.DetailsView;
import com.example.lab.services.ModelService;
import com.example.lab.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
public class OfferController {
    private OfferService offerService;
    private ModelService modelService;
    public OfferController(OfferService offerService, ModelService modelService) {
        this.offerService = offerService;
        this.modelService = modelService;
    }

     @ModelAttribute
     public AddOfferBinding addOfferBinding(){
        return new AddOfferBinding();
     }

    @GetMapping("/offers/all")
    public ModelAndView getAllOffers(ModelAndView modelAndView) {
        modelAndView.addObject("offers", offerService.getAllOffers());
        modelAndView.setViewName("offers");

        return modelAndView;
    }


    @GetMapping("/offers/add")
    public ModelAndView getAddOffers(ModelAndView modelAndView) {
        modelAndView.setViewName("offer-add");

        modelAndView.addObject("models",modelService.getAll());
        modelAndView.addObject("engines", Arrays.stream(Engine.values()).map(String::valueOf).collect(Collectors.toList()));
        modelAndView.addObject("transmission", Arrays.stream(Transmission.values()).map(String::valueOf).collect(Collectors.toList()));
        return modelAndView;
    }


    @GetMapping("/offers/update/{id}")
    public String getUpdate(@PathVariable Long id, Model model) {

        if (!model.containsAttribute("error")){

            model.addAttribute("addOfferBinding",offerService.getOfferById(id));
        }
       model.addAttribute("id",id);
        model.addAttribute("models",modelService.getAll());
        model.addAttribute("engines", Arrays.stream(Engine.values()).map(String::valueOf).collect(Collectors.toList()));
        model.addAttribute("transmission", Arrays.stream(Transmission.values()).map(String::valueOf).collect(Collectors.toList()));
        return "update";
    }

    @PatchMapping("/offers/update/{id}")
    public String updateOffer(@PathVariable Long id,@Valid AddOfferBinding addOfferBinding, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferBinding", addOfferBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferBinding", bindingResult);
            redirectAttributes.addFlashAttribute("error", true);
            return "redirect:/offers/update/"+id;
        }

        offerService.update(addOfferBinding,id);


        return "redirect:/offers/all";
    }



    @PostMapping("/offers/add")
    public String addOffer(@Valid AddOfferBinding addOfferBinding, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferBinding", addOfferBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferBinding", bindingResult);
            return "redirect:/offers/add";
        }

        offerService.save(addOfferBinding);


        return "redirect:/offers/all";
    }


    @GetMapping("/offers/details/{id}")
    public ModelAndView getDetails(ModelAndView modelAndView, @PathVariable Long id) {

        modelAndView.addObject("offerView", offerService.getOfferById(id));
        modelAndView.setViewName("details");
        return modelAndView;
    }

    @DeleteMapping("/offers/details/{id}")
    public ModelAndView DeleteOffer(ModelAndView modelAndView, @PathVariable Long id) {

        offerService.deleteById(id);
        modelAndView.setViewName("redirect:/offers/all");
        return modelAndView;
    }
}
