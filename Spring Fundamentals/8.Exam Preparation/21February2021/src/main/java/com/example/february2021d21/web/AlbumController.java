package com.example.february2021d21.web;

import com.example.february2021d21.CurrentUser;
import com.example.february2021d21.model.binding.AddAlbumBinding;
import com.example.february2021d21.model.entity.Album;
import com.example.february2021d21.service.AlbumService;
import com.example.february2021d21.service.ArtistService;
import com.example.february2021d21.service.UserService;
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
public class AlbumController {
    private ModelMapper modelMapper;
    private AlbumService albumService;
    private ArtistService artistService;
    private CurrentUser currentUser;
    private UserService userService;


    public AlbumController(ModelMapper modelMapper, AlbumService albumService, ArtistService artistService, CurrentUser currentUser, UserService userService) {
        this.modelMapper = modelMapper;
        this.albumService = albumService;
        this.artistService = artistService;
        this.currentUser = currentUser;
        this.userService = userService;
    }
    @ModelAttribute
    public AddAlbumBinding addAlbumBinding(){
        return new AddAlbumBinding();
    }

    @GetMapping("/home/addAlbum")
    public String getAlbum(Model model){

        model.addAttribute("artists",artistService.getAll());

        return "add-album";
    }

    @PostMapping("/home/addAlbum")
    public String postRegister(@Valid AddAlbumBinding addAlbumBinding, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addAlbumBinding",addAlbumBinding);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addAlbumBinding",bindingResult);

            return "redirect:/home/addAlbum";
        }
        Album album = modelMapper.map(addAlbumBinding, Album.class);
        album.setArtist(artistService.getByName(addAlbumBinding.getArtist()));
        album.setUser(userService.getById(currentUser.getId()));
        albumService.addAlbum(album);
        return "redirect:/home";
    }
}
