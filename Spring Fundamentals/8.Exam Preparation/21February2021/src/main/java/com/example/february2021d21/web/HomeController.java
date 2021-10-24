package com.example.february2021d21.web;

import com.example.february2021d21.model.view.AlbumView;
import com.example.february2021d21.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private AlbumService albumService;

    public HomeController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("")
    public String getIndex(){
        return "index";
    }


    @GetMapping("/home")
    public String getHome(Model model){
        albumService.getAll();

        List<AlbumView> albumViewList=albumService.getAll();

        Long copies=albumViewList.stream().mapToLong(AlbumView::getCopies).sum();
        model.addAttribute("albums",albumViewList);
        model.addAttribute("totalCopies",copies);
        return "home";
    }
    @GetMapping("/home/delete/{id}")
    public String deleteAlbum(@PathVariable Long id, Model model){
        albumService.deleteById(id);
        return "redirect:/home";
    }
}
