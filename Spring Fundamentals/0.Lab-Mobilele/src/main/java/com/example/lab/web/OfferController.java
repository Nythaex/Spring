package com.example.lab.web;

import com.example.lab.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfferController {
    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/offers/all")
    public ModelAndView getAllOffers(ModelAndView modelAndView){
         modelAndView.addObject("offers",offerService.getAllOffers());
        modelAndView.setViewName("offers");
       return modelAndView;
    }

    @GetMapping("/offers/add")
    public ModelAndView getAddOffers(ModelAndView modelAndView){
        modelAndView.setViewName("offer-add");
        return modelAndView;
    }
    @GetMapping("/offers/details/{id}")
    public ModelAndView getDetails(ModelAndView modelAndView, @PathVariable Long id){

         modelAndView.addObject("offerView",offerService.getOfferById(id));
        modelAndView.setViewName("details");
        return modelAndView;
    }
    @DeleteMapping("/offers/details/{id}")
    public ModelAndView DeleteOffer(ModelAndView modelAndView, @PathVariable Long id){

        offerService.deleteById(id);
        modelAndView.setViewName("redirect:/offers/all");
        return modelAndView;
    }
}
